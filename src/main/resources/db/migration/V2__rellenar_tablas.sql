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