INSERT INTO `usuario` (
    `email`, 
    `es_admin`, 
    `fecha_bloqueo`, 
    `fecha_registro`, 
    `nick_usuario`, 
    `nombre`, 
    `password`, 
    `primer_apellido`, 
    `segundo_apellido`
) VALUES (
    'usuario.ejemplo@email.com', 
    b'0', -- 0 para falso (no es admin), b'1' para verdadero
    NULL, 
    NOW(6), 
    'UserMaster99', 
    'Juan', 
    '$2y$12$eImiTXuWVxjM72fGC4WyeuupXpDJYy9H348FqC.f8S63VfH.f.g2', -- Ejemplo de password hasheado
    'Pérez', 
    'García'
);

INSERT INTO `usuario` (
    `email`, 
    `es_admin`, 
    `fecha_bloqueo`, 
    `fecha_registro`, 
    `nick_usuario`, 
    `nombre`, 
    `password`, 
    `primer_apellido`, 
    `segundo_apellido`
) VALUES (
    'admin@sistema.com', 
    b'1', 
    NULL, 
    NOW(6), 
    'admin_root', 
    'Ana', 
    '$2y$12$L80M.vR/9p.IIn9p7J/K9O1vX7oZ8L3e5g6h7i8j9k0l1m2n3o4p5', 
    'Rodríguez', 
    'López'
);

INSERT INTO `usuario` (
    `email`, 
    `es_admin`, 
    `fecha_registro`, 
    `nick_usuario`, 
    `nombre`, 
    `password`, 
    `primer_apellido`
) VALUES (
    'marta.sanz@correo.es', 
    b'0', 
    NOW(6), 
    'marta_dev', 
    'Marta', 
    '$2y$12$ZqXwEcRvTbYnUmOiPlKjHhGfDsAaSzXxCcVvBbNnMmLlKk JjIiHhG', 
    'Sanz'
);

INSERT INTO `score_financiero` (
    `fecha_calculo`, 
    `nivel`, 
    `valor_maximo`, 
    `usuario_id`
) VALUES (
    NOW(6), 
    850, 
    1000, 
    1
);

INSERT INTO `score_financiero` (
    `fecha_calculo`, 
    `nivel`, 
    `valor_maximo`, 
    `usuario_id`
) VALUES (
    NOW(6), 
    920, 
    1000, 
    2
);

INSERT INTO `score_financiero` (
    `fecha_calculo`, 
    `nivel`, 
    `valor_maximo`, 
    `usuario_id`
) VALUES (
    NOW(6), 
    640, 
    1000, 
    3
);

