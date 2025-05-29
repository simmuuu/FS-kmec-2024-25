const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();

// Middleware
app.use(cors());
app.use(express.json());

// MongoDB connection
mongoose.connect(process.env.MONGODB_URI || 'mongodb://simmu:meowgosling@localhost:27017/kmecFS?authSource=admin', {

});

const db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));
db.once('open', () => {
  console.log('Connected to MongoDB');
});

// Profile Schema
const profileSchema = new mongoose.Schema({
  // Personal Information
  name: {
    type: String,
    required: true,
    trim: true
  },
  email: {
    type: String,
    required: true,
    trim: true,
    lowercase: true
  },
  phone: {
    type: String,
    required: true,
    trim: true
  },
  // Education Information
  degree: {
    type: String,
    required: true,
    trim: true
  },
  institution: {
    type: String,
    required: true,
    trim: true
  },
  year: {
    type: Number,
    required: true
  },
  // Interests and Achievements
  interests: {
    type: [String],
    default: []
  },
  achievements: {
    type: [String],
    default: []
  }
}, {
  timestamps: true
});

const Profile = mongoose.model('Profile', profileSchema);

// Routes

// Get all profiles
app.get('/api/profiles', async (req, res) => {
  try {
    const profiles = await Profile.find().sort({ createdAt: -1 });
    res.json(profiles);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Get single profile by ID
app.get('/api/profiles/:id', async (req, res) => {
  try {
    const profile = await Profile.findById(req.params.id);
    if (!profile) {
      return res.status(404).json({ error: 'Profile not found' });
    }
    res.json(profile);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Create new profile
app.post('/api/profiles', async (req, res) => {
  try {
    const {
      name,
      email,
      phone,
      degree,
      institution,
      year,
      interests,
      achievements
    } = req.body;

    // Validation
    if (!name || !email || !phone || !degree || !institution || !year) {
      return res.status(400).json({ 
        error: 'All required fields must be provided' 
      });
    }

    // Process comma-separated strings into arrays
    const processedInterests = interests 
      ? interests.split(',').map(item => item.trim()).filter(item => item)
      : [];
    
    const processedAchievements = achievements 
      ? achievements.split(',').map(item => item.trim()).filter(item => item)
      : [];

    const profile = new Profile({
      name,
      email,
      phone,
      degree,
      institution,
      year: parseInt(year),
      interests: processedInterests,
      achievements: processedAchievements
    });

    await profile.save();
    res.status(201).json(profile);
  } catch (error) {
    if (error.name === 'ValidationError') {
      const errors = Object.values(error.errors).map(err => err.message);
      res.status(400).json({ error: errors.join(', ') });
    } else {
      res.status(500).json({ error: error.message });
    }
  }
});

// Update profile
app.put('/api/profiles/:id', async (req, res) => {
  try {
    const {
      name,
      email,
      phone,
      degree,
      institution,
      year,
      interests,
      achievements
    } = req.body;

    const processedInterests = interests 
      ? interests.split(',').map(item => item.trim()).filter(item => item)
      : [];
    
    const processedAchievements = achievements 
      ? achievements.split(',').map(item => item.trim()).filter(item => item)
      : [];

    const profile = await Profile.findByIdAndUpdate(
      req.params.id,
      {
        name,
        email,
        phone,
        degree,
        institution,
        year: parseInt(year),
        interests: processedInterests,
        achievements: processedAchievements
      },
      { new: true, runValidators: true }
    );

    if (!profile) {
      return res.status(404).json({ error: 'Profile not found' });
    }

    res.json(profile);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Delete profile
app.delete('/api/profiles/:id', async (req, res) => {
  try {
    const profile = await Profile.findByIdAndDelete(req.params.id);
    if (!profile) {
      return res.status(404).json({ error: 'Profile not found' });
    }
    res.json({ message: 'Profile deleted successfully' });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Health check endpoint
app.get('/api/health', (req, res) => {
  res.json({ status: 'Server is running', timestamp: new Date().toISOString() });
});

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});