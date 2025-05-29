// Function to get random stock status
const getRandomStockStatus = () => {
  return Math.random() > 0.2; // 80% chance of being in stock
};const mongoose = require('mongoose');

// Product Schema (same as in server.js)
const productSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    trim: true
  },
  price: {
    type: Number,
    required: true,
    min: 0
  },
  category: {
    type: String,
    required: true,
    trim: true
  },
  inStock: {
    type: Boolean,
    required: true,
    default: true
  }
}, {
  timestamps: true
});

const Product = mongoose.model('Product', productSchema);

// Categorized product data - products matched with appropriate categories
const categorizedProducts = {
  'Electronics': [
    'iPhone 14', 'iPhone 15', 'Samsung Galaxy S23', 'Samsung Galaxy S24', 'Google Pixel 8',
    'OnePlus 11', 'Xiaomi 13', 'LG OLED TV 55"', 'Samsung QLED TV', 'Sony Bravia TV',
    'Apple Watch Series 9', 'Samsung Galaxy Watch', 'Fitbit Versa', 'Sony Camera Alpha',
    'Canon EOS R6', 'GoPro Hero 12', 'DJI Mini Drone', 'Ring Video Doorbell'
  ],
  'Computers': [
    'MacBook Pro 14"', 'MacBook Air M2', 'Dell XPS 13', 'Dell XPS 15', 'HP Spectre x360',
    'Lenovo ThinkPad X1', 'Surface Laptop 5', 'ASUS ZenBook', 'Acer Swift 3',
    'HP Pavilion', 'iMac 24"', 'Mac Studio', 'Dell OptiPlex', 'HP EliteDesk'
  ],
  'Audio': [
    'Sony WH-1000XM4', 'Sony WH-1000XM5', 'AirPods Pro 2', 'AirPods Max', 'Bose QuietComfort',
    'Sennheiser HD 660S', 'Audio-Technica ATH-M50x', 'JBL Flip 6', 'Sonos One',
    'Marshall Acton', 'Beats Studio Buds', 'Galaxy Buds Pro', 'Sony WF-1000XM4'
  ],
  'Gaming': [
    'PlayStation 5', 'Xbox Series X', 'Xbox Series S', 'Nintendo Switch OLED',
    'Steam Deck', 'Gaming Chair Pro', 'RGB Mechanical Keyboard', 'Gaming Mouse Wireless',
    'Gaming Headset', 'PS5 Controller', 'Xbox Wireless Controller', 'Nintendo Pro Controller',
    'Gaming Monitor 27"', 'RTX 4080 Graphics Card', 'Razer DeathAdder Mouse'
  ],
  'Home & Kitchen': [
    'Ninja Air Fryer', 'Instant Pot Duo', 'Keurig Coffee Maker', 'Vitamix Blender',
    'KitchenAid Stand Mixer', 'Dyson V15 Vacuum', 'Roomba i7+', 'Nespresso Machine',
    'Cuisinart Food Processor', 'Hamilton Beach Blender', 'Black+Decker Toaster',
    'Philips Air Fryer', 'Breville Smart Oven', 'Shark Navigator Vacuum'
  ],
  'Sports & Fitness': [
    'Nike Air Max Running Shoes', 'Adidas Ultraboost', 'Peloton Bike+', 'NordicTrack Treadmill',
    'Yoga Mat Premium', 'Resistance Bands Set', 'Adjustable Dumbbells', 'Kettlebell 20lb',
    'Foam Roller', 'Fitbit Charge 5', 'Garmin Forerunner', 'Under Armour Sports Bra',
    'Nike Dri-FIT Shorts', 'Protein Shaker Bottle', 'Gym Towel Microfiber'
  ],
  'Clothing': [
    'Levi\'s 501 Jeans', 'Nike Hoodie', 'Adidas Track Jacket', 'Uniqlo T-Shirt',
    'Patagonia Fleece', 'North Face Winter Jacket', 'Ray-Ban Sunglasses', 'Converse Sneakers',
    'Vans Old Skool', 'Champion Sweatshirt', 'Tommy Hilfiger Polo', 'Calvin Klein Underwear',
    'Hanes Cotton Socks', 'New Era Baseball Cap', 'Timberland Boots'
  ],
  'Furniture': [
    'IKEA Malm Desk', 'Herman Miller Chair', 'Standing Desk Electric', 'Ergonomic Office Chair',
    'Bookshelf 5-Tier', 'Coffee Table Oak', 'Dining Table Set', 'Sofa 3-Seater',
    'Bed Frame Queen', 'Nightstand White', 'Dresser 6-Drawer', 'TV Stand Modern',
    'Storage Ottoman', 'Floor Lamp LED', 'Table Lamp Touch'
  ],
  'Accessories': [
    'iPhone 14 Case', 'Samsung Galaxy Case', 'Screen Protector Tempered', 'Phone Mount Car',
    'Wireless Charger Pad', 'USB-C Cable 6ft', 'Lightning Cable MFi', 'Power Bank 20000mAh',
    'Bluetooth Adapter', 'Phone Ring Holder', 'Pop Socket', 'Wallet Phone Case',
    'Car Charger Dual USB', 'Cable Organizer', 'Phone Stand Adjustable'
  ],
  'Office Supplies': [
    'Stapler Heavy Duty', 'Paper Shredder', 'Whiteboard Magnetic', 'Desk Organizer Bamboo',
    'File Cabinet 2-Drawer', 'Monitor Stand Adjustable', 'Laptop Stand Portable',
    'Desk Pad Large', 'Ergonomic Wrist Rest', 'Paper Clips Assorted', 'Sticky Notes Pack',
    'Highlighter Set', 'Ballpoint Pens', 'Mechanical Pencils', 'Notebook Spiral'
  ],
  'Travel': [
    'Samsonite Luggage', 'Away Carry-On', 'Travel Backpack 40L', 'Packing Cubes Set',
    'Travel Pillow Memory Foam', 'Portable Charger Travel', 'Universal Travel Adapter',
    'Compression Socks', 'Travel Wallet RFID', 'Luggage Scale Digital',
    'Travel Toiletry Bag', 'Insulated Water Bottle', 'Travel Mug Spill-Proof',
    'Portable Bluetooth Speaker', 'Noise Cancelling Earbuds'
  ]
};

// Function to get appropriate price range based on category
const getPriceByCategory = (category) => {
  const priceRanges = {
    'Electronics': { min: 99, max: 1499 },
    'Computers': { min: 599, max: 2999 },
    'Audio': { min: 29, max: 599 },
    'Gaming': { min: 39, max: 799 },
    'Home & Kitchen': { min: 19, max: 499 },
    'Sports & Fitness': { min: 9, max: 299 },
    'Clothing': { min: 12, max: 199 },
    'Furniture': { min: 49, max: 899 },
    'Accessories': { min: 5, max: 89 },
    'Office Supplies': { min: 3, max: 149 },
    'Travel': { min: 15, max: 399 }
  };
  
  const range = priceRanges[category] || { min: 10, max: 100 };
  return Math.round((Math.random() * (range.max - range.min) + range.min) * 100) / 100;
};

// Function to generate sample products with matching names and categories
const generateSampleProducts = (count = 100) => {
  const products = [];
  const categories = Object.keys(categorizedProducts);
  const productsPerCategory = Math.floor(count / categories.length);
  const remainder = count % categories.length;
  
  categories.forEach((category, index) => {
    const categoryProducts = categorizedProducts[category];
    let productsToGenerate = productsPerCategory;
    
    // Distribute remainder products among first few categories
    if (index < remainder) {
      productsToGenerate++;
    }
    
    for (let i = 0; i < productsToGenerate; i++) {
      // Select a random product from this category
      const randomProductIndex = Math.floor(Math.random() * categoryProducts.length);
      let productName = categoryProducts[randomProductIndex];
      
      // Add variation to avoid exact duplicates
      const variation = Math.floor(Math.random() * 99) + 1;
      if (Math.random() > 0.3) { // 70% chance to add variation
        productName += ` ${variation}`;
      }
      
      products.push({
        name: productName,
        price: getPriceByCategory(category),
        category: category,
        inStock: getRandomStockStatus()
      });
    }
  });
  
  // Shuffle the products array to mix categories
  for (let i = products.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [products[i], products[j]] = [products[j], products[i]];
  }
  
  return products;
};

// Main seeding function
const seedDatabase = async () => {
  try {
    console.log('🌱 Starting database seeding...');
    
    // Connect to MongoDB
    await mongoose.connect('mongodb://simmu:meowgosling@localhost:27017/employeeDB?authSource=admin', {
      useNewUrlParser: true,
      useUnifiedTopology: true,
    });
    
    console.log('✅ Connected to MongoDB');

    // Clear existing products (optional)
    const existingCount = await Product.countDocuments();
    if (existingCount > 0) {
      console.log(`🗑️  Found ${existingCount} existing products. Clearing database...`);
      await Product.deleteMany({});
      console.log('✅ Database cleared');
    }

    // Generate and insert sample products
    console.log('🏭 Generating 100 sample products...');
    const sampleProducts = generateSampleProducts(100);
    
    console.log('💾 Inserting products into database...');
    const insertedProducts = await Product.insertMany(sampleProducts);
    
    console.log(`✅ Successfully seeded ${insertedProducts.length} products!`);
    
    // Display some sample data
    console.log('\n📊 Sample products:');
    const sampleData = insertedProducts.slice(0, 5);
    sampleData.forEach((product, index) => {
      console.log(`${index + 1}. ${product.name} - $${product.price} (${product.category}) - ${product.inStock ? 'In Stock' : 'Out of Stock'}`);
    });

    // Display category distribution
    const categoryStats = await Product.aggregate([
      { $group: { _id: '$category', count: { $sum: 1 } } },
      { $sort: { count: -1 } }
    ]);
    
    console.log('\n📈 Category distribution:');
    categoryStats.forEach(stat => {
      console.log(`- ${stat._id}: ${stat.count} products`);
    });

    console.log('\n🎉 Database seeding completed successfully!');
    
  } catch (error) {
    console.error('❌ Error seeding database:', error.message);
    process.exit(1);
  } finally {
    // Close the connection
    await mongoose.connection.close();
    console.log('🔌 Database connection closed');
    process.exit(0);
  }
};

// Run the seeder if this file is executed directly
if (require.main === module) {
  seedDatabase();
}

module.exports = { seedDatabase, generateSampleProducts };