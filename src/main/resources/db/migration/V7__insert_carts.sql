
INSERT INTO categories (name, description) VALUES
                                               ('Gaming', 'Gaming consoles and accessories'),
                                               ('Audio', 'Headphones and speakers'),
                                               ('Wearables', 'Smart watches and fitness devices');


INSERT INTO carts (user_id)
SELECT id FROM users
WHERE email IN (
'akim@marketplace.kz',
'daulet@marketplace.kz',
'karim@marketplace.kz',
'ernar@marketplace.kz'
    );

INSERT INTO cart_items (cart_id, product_id, quantity)
VALUES
    (
        (SELECT c.id FROM carts c
                              JOIN users u ON c.user_id = u.id
         WHERE u.email='ernar@marketplace.kz'),
        (SELECT id FROM products WHERE name='iPhone 15 Pro Max'),
        1
    ),
    (
        (SELECT c.id FROM carts c
                              JOIN users u ON c.user_id = u.id
         WHERE u.email='daulet@marketplace.kz'),
        (SELECT id FROM products WHERE name='PlayStation 5'),
        2
    );
