-- Orders
INSERT INTO orders (user_id, created_at, status)
SELECT id, NOW(), 'CREATED'
FROM users
WHERE email IN ('ernar@marketplace.kz','daulet@marketplace.kz');


INSERT INTO order_items (order_id, product_id, quantity, price_at_purchase)
VALUES
    (
        (SELECT id FROM orders LIMIT 1),
    (SELECT id FROM products WHERE name='iPhone 15 Pro Max'),
    1,
    1350000
    ),
(
 (SELECT id FROM orders OFFSET 1 LIMIT 1),
 (SELECT id FROM products WHERE name='PlayStation 5'),
 1,
 420000
);


INSERT INTO payments (order_id, amount, status, paid_at)
VALUES
    (
        (SELECT id FROM orders LIMIT 1),
    1350000,
    'PAID',
    NOW()
    ),
(
 (SELECT id FROM orders OFFSET 1 LIMIT 1),
 420000,
 'PAID',
 NOW()
);
