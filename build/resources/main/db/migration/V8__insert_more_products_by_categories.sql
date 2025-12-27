
INSERT INTO products (name, description, price, stock_quantity, category_id, seller_id) VALUES


('Nintendo Switch OLED', 'Portable console with OLED display', 189990, 20,
 (SELECT id FROM categories WHERE name='Gaming'),
 (SELECT id FROM sellers LIMIT 1)
    ),
('DualSense Controller', 'PS5 wireless controller', 34990, 50,
 (SELECT id FROM categories WHERE name='Gaming'),
 (SELECT id FROM sellers LIMIT 1)
),
('Gaming Headset HyperX Cloud II', 'Comfort headset for PC/PS/Xbox', 49990, 30,
 (SELECT id FROM categories WHERE name='Gaming'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),


('AirPods Pro 2', 'Apple noise cancelling earbuds', 129990, 25,
 (SELECT id FROM categories WHERE name='Audio'),
 (SELECT id FROM sellers LIMIT 1)
),
('Sony WH-1000XM5', 'Premium noise cancelling headphones', 199990, 15,
 (SELECT id FROM categories WHERE name='Audio'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),
('JBL Charge 5', 'Portable Bluetooth speaker', 79990, 40,
 (SELECT id FROM categories WHERE name='Audio'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),


('Apple Watch Series 9', 'Smart watch with health tracking', 219990, 18,
 (SELECT id FROM categories WHERE name='Wearables'),
 (SELECT id FROM sellers LIMIT 1)
),
('Samsung Galaxy Watch 6', 'Wearable for Android ecosystem', 169990, 22,
 (SELECT id FROM categories WHERE name='Wearables'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),
('Xiaomi Smart Band 8', 'Fitness tracker budget', 19990, 60,
 (SELECT id FROM categories WHERE name='Wearables'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
);
