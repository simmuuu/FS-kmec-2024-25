import React, { useReducer, useState, useEffect } from 'react';
import {
  AppBar,
  Toolbar,
  Typography,
  Container,
  Paper,
  TextField,
  Button,
  Stepper,
  Step,
  StepLabel,
  Box,
  Card,
  CardContent,
  CardActions,
  Grid,
  Chip,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  CircularProgress,
  Alert,
  Tabs,
  Tab,
  IconButton
} from '@mui/material';
import { styled } from '@mui/material/styles';
import { ArrowBack } from '@mui/icons-material';

// Styled components
const StyledPaper = styled(Paper)(({ theme }) => ({
  padding: theme.spacing(4),
  marginTop: theme.spacing(2),
  marginBottom: theme.spacing(2),
}));

const StyledCard = styled(Card)(({ theme }) => ({
  height: '100%',
  display: 'flex',
  flexDirection: 'column',
  transition: 'transform 0.2s ease-in-out',
  cursor: 'pointer',
  '&:hover': {
    transform: 'translateY(-2px)',
    boxShadow: theme.shadows[8],
  },
}));

// Form reducer
const initialFormState = {
  currentStep: 0,
  formData: {
    name: '',
    email: '',
    phone: '',
    degree: '',
    institution: '',
    year: '',
    interests: '',
    achievements: ''
  },
  errors: {},
  isSubmitting: false
};

const formReducer = (state, action) => {
  switch (action.type) {
    case 'UPDATE_FIELD':
      return {
        ...state,
        formData: {
          ...state.formData,
          [action.field]: action.value
        },
        errors: {
          ...state.errors,
          [action.field]: ''
        }
      };
    
    case 'NEXT_STEP':
      return {
        ...state,
        currentStep: state.currentStep + 1
      };
    
    case 'PREV_STEP':
      return {
        ...state,
        currentStep: state.currentStep - 1
      };
    
    case 'SET_ERRORS':
      return {
        ...state,
        errors: action.errors
      };
    
    case 'RESET_FORM':
      return initialFormState;
      
    case 'SET_SUBMITTING':
      return {
        ...state,
        isSubmitting: action.isSubmitting
      };
      
    default:
      return state;
  }
};

// API base URL - change this to your backend URL
const API_BASE_URL = 'http://localhost:5000/api';

// Multi-step form component
const MultiStepForm = ({ onSubmitSuccess }) => {
  const [state, dispatch] = useReducer(formReducer, initialFormState);
  const [submitError, setSubmitError] = useState('');

  const steps = ['Personal Info', 'Education', 'Interests', 'Achievements'];

  const updateField = (field, value) => {
    dispatch({ type: 'UPDATE_FIELD', field, value });
  };

  const validateStep = (step) => {
    const errors = {};
    const { formData } = state;

    switch (step) {
      case 0: // Personal Info
        if (!formData.name.trim()) errors.name = 'Name is required';
        if (!formData.email.trim()) errors.email = 'Email is required';
        else if (!/\S+@\S+\.\S+/.test(formData.email)) errors.email = 'Email is invalid';
        if (!formData.phone.trim()) errors.phone = 'Phone is required';
        break;
      case 1: // Education
        if (!formData.degree.trim()) errors.degree = 'Degree is required';
        if (!formData.institution.trim()) errors.institution = 'Institution is required';
        if (!formData.year.trim()) errors.year = 'Year is required';
        else if (isNaN(formData.year) || formData.year < 1900 || formData.year > new Date().getFullYear() + 10) {
          errors.year = 'Please enter a valid year';
        }
        break;
      default:
        break;
    }

    dispatch({ type: 'SET_ERRORS', errors });
    return Object.keys(errors).length === 0;
  };

  const nextStep = () => {
    if (validateStep(state.currentStep)) {
      dispatch({ type: 'NEXT_STEP' });
    }
  };

  const prevStep = () => {
    dispatch({ type: 'PREV_STEP' });
  };

  const handleSubmit = async () => {
    if (!validateStep(state.currentStep)) return;

    dispatch({ type: 'SET_SUBMITTING', isSubmitting: true });
    setSubmitError('');

    try {
      const response = await fetch(`${API_BASE_URL}/profiles`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(state.formData),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || 'Failed to submit profile');
      }

      const result = await response.json();
      dispatch({ type: 'RESET_FORM' });
      onSubmitSuccess();
    } catch (error) {
      setSubmitError(error.message);
    } finally {
      dispatch({ type: 'SET_SUBMITTING', isSubmitting: false });
    }
  };

  const renderStepContent = () => {
    const { formData, errors } = state;

    switch (state.currentStep) {
      case 0:
        return (
          <Box>
            <Typography variant="h6" gutterBottom>Personal Information</Typography>
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Name"
                  value={formData.name}
                  onChange={(e) => updateField('name', e.target.value)}
                  error={!!errors.name}
                  helperText={errors.name}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Email"
                  type="email"
                  value={formData.email}
                  onChange={(e) => updateField('email', e.target.value)}
                  error={!!errors.email}
                  helperText={errors.email}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Phone"
                  value={formData.phone}
                  onChange={(e) => updateField('phone', e.target.value)}
                  error={!!errors.phone}
                  helperText={errors.phone}
                  required
                />
              </Grid>
            </Grid>
          </Box>
        );

      case 1:
        return (
          <Box>
            <Typography variant="h6" gutterBottom>Education Information</Typography>
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Degree"
                  value={formData.degree}
                  onChange={(e) => updateField('degree', e.target.value)}
                  error={!!errors.degree}
                  helperText={errors.degree}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Institution"
                  value={formData.institution}
                  onChange={(e) => updateField('institution', e.target.value)}
                  error={!!errors.institution}
                  helperText={errors.institution}
                  required
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  label="Year"
                  type="number"
                  value={formData.year}
                  onChange={(e) => updateField('year', e.target.value)}
                  error={!!errors.year}
                  helperText={errors.year}
                  required
                />
              </Grid>
            </Grid>
          </Box>
        );

      case 2:
        return (
          <Box>
            <Typography variant="h6" gutterBottom>Interests</Typography>
            <TextField
              fullWidth
              label="Interests (comma-separated)"
              multiline
              rows={4}
              value={formData.interests}
              onChange={(e) => updateField('interests', e.target.value)}
              helperText="Enter your interests separated by commas (e.g., Reading, Swimming, Programming)"
              placeholder="Reading, Swimming, Programming, Photography"
            />
          </Box>
        );

      case 3:
        return (
          <Box>
            <Typography variant="h6" gutterBottom>Achievements</Typography>
            <TextField
              fullWidth
              label="Achievements (comma-separated)"
              multiline
              rows={4}
              value={formData.achievements}
              onChange={(e) => updateField('achievements', e.target.value)}
              helperText="Enter your achievements separated by commas"
              placeholder="First place in coding competition, Dean's list, Published research paper"
            />
          </Box>
        );

      default:
        return null;
    }
  };

  return (
    <StyledPaper>
      <Stepper activeStep={state.currentStep} alternativeLabel>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>

      <Box sx={{ mt: 4, mb: 4 }}>
        {renderStepContent()}
      </Box>

      {submitError && (
        <Alert severity="error" sx={{ mb: 2 }}>
          {submitError}
        </Alert>
      )}

      <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
        <Button
          disabled={state.currentStep === 0}
          onClick={prevStep}
          variant="outlined"
        >
          Previous
        </Button>

        {state.currentStep === steps.length - 1 ? (
          <Button
            variant="contained"
            onClick={handleSubmit}
            disabled={state.isSubmitting}
            startIcon={state.isSubmitting ? <CircularProgress size={20} /> : null}
          >
            {state.isSubmitting ? 'Submitting...' : 'Submit'}
          </Button>
        ) : (
          <Button variant="contained" onClick={nextStep}>
            Next
          </Button>
        )}
      </Box>
    </StyledPaper>
  );
};

// Profile List Component
const ProfileList = ({ onProfileClick }) => {
  const [profiles, setProfiles] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchProfiles();
  }, []);

  const fetchProfiles = async () => {
    try {
      setLoading(true);
      const response = await fetch(`${API_BASE_URL}/profiles`);
      if (!response.ok) {
        throw new Error('Failed to fetch profiles');
      }
      const data = await response.json();
      setProfiles(data);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <Box display="flex" justifyContent="center" p={4}>
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return (
      <Alert severity="error" sx={{ m: 2 }}>
        {error}
      </Alert>
    );
  }

  return (
    <Container maxWidth="lg" sx={{ mt: 2, mb: 4 }}>
      <Typography variant="h4" gutterBottom>
        All Profiles ({profiles.length})
      </Typography>
      
      {profiles.length === 0 ? (
        <Paper sx={{ p: 4, textAlign: 'center' }}>
          <Typography variant="h6" color="textSecondary">
            No profiles found. Create your first profile!
          </Typography>
        </Paper>
      ) : (
        <Grid container spacing={3}>
          {profiles.map((profile) => (
            <Grid item xs={12} sm={6} md={4} key={profile._id}>
              <StyledCard onClick={() => onProfileClick(profile)}>
                <CardContent sx={{ flexGrow: 1 }}>
                  <Typography variant="h6" gutterBottom>
                    {profile.name}
                  </Typography>
                  <Typography color="textSecondary" gutterBottom>
                    {profile.email}
                  </Typography>
                  <Typography variant="body2">
                    {profile.degree} from {profile.institution}
                  </Typography>
                  <Typography variant="caption" color="textSecondary">
                    Class of {profile.year}
                  </Typography>
                </CardContent>
                <CardActions>
                  <Button size="small" color="primary">
                    View Details
                  </Button>
                </CardActions>
              </StyledCard>
            </Grid>
          ))}
        </Grid>
      )}
    </Container>
  );
};

// Profile Detail Full Page Component
const ProfileDetailFullPage = ({ profile, onBack }) => {
  if (!profile) return null;

  return (
    <Container maxWidth="lg" sx={{ mt: 2, mb: 4 }}>
      <Box sx={{ display: 'flex', alignItems: 'center', mb: 3 }}>
        <IconButton onClick={onBack} sx={{ mr: 2 }}>
          <ArrowBack />
        </IconButton>
        <Typography variant="h4">Profile Details</Typography>
      </Box>

      <StyledPaper>
        <Typography variant="h3" gutterBottom color="primary">
          {profile.name}
        </Typography>
        
        <Grid container spacing={4}>
          <Grid item xs={12} md={6}>
            <Paper sx={{ p: 3, height: '100%', display: 'flex', flexDirection: 'column' }}>
              <Typography variant="h5" gutterBottom color="primary">
                Personal Information
              </Typography>
              <Box sx={{ mt: 2 }}>
                <Typography variant="body1" sx={{ mb: 1 }}>
                  <strong>Email:</strong> {profile.email}
                </Typography>
                <Typography variant="body1">
                  <strong>Phone:</strong> {profile.phone}
                </Typography>
              </Box>
            </Paper>
          </Grid>
          
          <Grid item xs={12} md={6}>
            <Paper sx={{ p: 3, height: '100%', display: 'flex', flexDirection: 'column' }}>
              <Typography variant="h5" gutterBottom color="primary">
                Education
              </Typography>
              <Box sx={{ mt: 2 }}>
                <Typography variant="body1" sx={{ mb: 1 }}>
                  <strong>Degree:</strong> {profile.degree}
                </Typography>
                <Typography variant="body1" sx={{ mb: 1 }}>
                  <strong>Institution:</strong> {profile.institution}
                </Typography>
                <Typography variant="body1">
                  <strong>Year:</strong> {profile.year}
                </Typography>
              </Box>
            </Paper>
          </Grid>
          
          {profile.interests && profile.interests.length > 0 && (
            <Grid item xs={12}>
              <Paper sx={{ p: 3, mt: 2 }}>
                <Typography variant="h5" gutterBottom color="primary">
                  Interests
                </Typography>
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 1, mt: 2 }}>
                  {profile.interests.split(',').map((interest, index) => (
                    <Chip 
                      key={index} 
                      label={interest.trim()} 
                      color="primary" 
                      variant="outlined" 
                      size="medium"
                    />
                  ))}
                </Box>
              </Paper>
            </Grid>
          )}
          
          {profile.achievements && profile.achievements.length > 0 && (
            <Grid item xs={12}>
              <Paper sx={{ p: 3, mt: 2 }}>
                <Typography variant="h5" gutterBottom color="primary">
                  Achievements
                </Typography>
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 1, mt: 2 }}>
                  {profile.achievements.split(',').map((achievement, index) => (
                    <Chip 
                      key={index} 
                      label={achievement.trim()} 
                      color="secondary" 
                      variant="outlined" 
                      size="medium"
                    />
                  ))}
                </Box>
              </Paper>
            </Grid>
          )}
        </Grid>
      </StyledPaper>
    </Container>
  );
};

// Main App Component
const App = () => {
  const [currentTab, setCurrentTab] = useState(0);
  const [selectedProfile, setSelectedProfile] = useState(null);
  const [showProfileDetail, setShowProfileDetail] = useState(false);

  const handleTabChange = (event, newValue) => {
    setCurrentTab(newValue);
    setShowProfileDetail(false);
    setSelectedProfile(null);
  };

  const handleSubmitSuccess = () => {
    setCurrentTab(1); // Switch to "All Profiles" tab
    setShowProfileDetail(false);
  };

  const handleProfileClick = (profile) => {
    setSelectedProfile(profile);
    setShowProfileDetail(true);
  };

  const handleBackToList = () => {
    setShowProfileDetail(false);
    setSelectedProfile(null);
  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            KMIT Profile Manager
          </Typography>
        </Toolbar>
      </AppBar>

      <Container maxWidth="lg">
        {!showProfileDetail && (
          <Box sx={{ borderBottom: 1, borderColor: 'divider', mt: 2 }}>
            <Tabs value={currentTab} onChange={handleTabChange} centered>
              <Tab label="New Profile" />
              <Tab label="All Profiles" />
            </Tabs>
          </Box>
        )}

        {!showProfileDetail && currentTab === 0 && (
          <MultiStepForm onSubmitSuccess={handleSubmitSuccess} />
        )}

        {!showProfileDetail && currentTab === 1 && (
          <ProfileList onProfileClick={handleProfileClick} />
        )}

        {showProfileDetail && (
          <ProfileDetailFullPage 
            profile={selectedProfile} 
            onBack={handleBackToList}
          />
        )}
      </Container>
    </Box>
  );
};

export default App;