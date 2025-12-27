
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.name = 'ADMIN'
WHERE u.email = 'Dias_professor@marketplace.kz'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur
    WHERE ur.user_id = u.id AND ur.role_id = r.id
);


INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.name = 'SELLER'
WHERE u.email IN ('messi@marketplace.kz', 'ronaldo@marketplace.kz')
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur
    WHERE ur.user_id = u.id AND ur.role_id = r.id
);


INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
         JOIN roles r ON r.name = 'USER'
WHERE u.email IN (
                  'akim@marketplace.kz',
                  'daulet@marketplace.kz',
                  'karim@marketplace.kz',
                  'ernar@marketplace.kz'
    )
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur
    WHERE ur.user_id = u.id AND ur.role_id = r.id
);


INSERT INTO sellers (user_id, active)
SELECT u.id, TRUE
FROM users u
WHERE u.email IN ('messi@marketplace.kz', 'ronaldo@marketplace.kz')
  AND NOT EXISTS (
    SELECT 1 FROM sellers s
    WHERE s.user_id = u.id
);
