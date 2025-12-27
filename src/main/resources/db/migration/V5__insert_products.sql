INSERT INTO categories (name, description) VALUES
    ('Electronics', 'Phones, laptops, consoles');

INSERT INTO products (name, description, price, stock_quantity, category_id, seller_id) VALUES

('iPhone 15 Pro Max', 'Apple flagship smartphone', 1350000, 8,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers LIMIT 1)
    ),
('MacBook Pro M2', 'Apple MacBook Pro with M2 chip', 1650000, 5,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers LIMIT 1)
),
('PlayStation 5', 'Sony gaming console', 420000, 12,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers LIMIT 1)
),


('Samsung Galaxy S24 Ultra', 'Samsung flagship phone', 980000, 10,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),
('MacBook Air M2', 'Apple lightweight laptop', 1100000, 7,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
),
('Xbox Series X', 'Microsoft gaming console', 450000, 9,
 (SELECT id FROM categories WHERE name='Electronics'),
 (SELECT id FROM sellers OFFSET 1 LIMIT 1)
);
