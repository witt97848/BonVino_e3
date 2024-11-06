CREATE TABLE IF NOT EXISTS bodegas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  descripcion VARCHAR(255),
  historia VARCHAR(255),
  nombre VARCHAR(255),
  region_id INT NOT NULL,
  FOREIGN KEY (region_id) REFERENCES regiones_vitivinicolas(id)
);


CREATE TABLE IF NOT EXISTS paises (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS provincias (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre VARCHAR(255),
  pais_id INT,
  FOREIGN KEY (pais_id) REFERENCES paises(id)
);

CREATE TABLE IF NOT EXISTS regiones_vitivinicolas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre VARCHAR(255),
  descripcion VARCHAR(255),
  provincia_id INT,
  FOREIGN KEY (provincia_id) REFERENCES provincias(id)
);


CREATE TABLE IF NOT EXISTS vinos (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre VARCHAR(255),
  bodega_id INT NOT NULL,
  precio_ars FLOAT,
  FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
);

CREATE TABLE IF NOT EXISTS varietales (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  descripcion VARCHAR(255),
  porcentaje_composicion FLOAT,
  tipo_uva_id INT,
  FOREIGN KEY (tipo_uva_id) REFERENCES tipos_uva(id)
);

CREATE TABLE IF NOT EXISTS tipos_uva (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  descripcion VARCHAR(255),
  nombre VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS reseñas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  comentario VARCHAR(255),
  es_premium BOOLEAN,
  fecha_reseña DATE,
  puntaje FLOAT,
  vino_id INT,
  FOREIGN KEY (vino_id) REFERENCES vinos(id)
);

-- Inserción en la tabla paises
INSERT INTO paises (nombre) VALUES
('Argentina'),
('Chile'),
('España'),
('Francia'),
('Italia');

-- Inserción en la tabla provincias
INSERT INTO provincias (nombre, pais_id) VALUES
('Mendoza', 1),
('San Juan', 1),
('Valparaíso', 2),
('Cataluña', 3),
('Borgoña', 4),
('Toscana', 5);

-- Inserción en la tabla regiones_vitivinicolas
INSERT INTO regiones_vitivinicolas (nombre, descripcion, provincia_id) VALUES
('Valle de Uco', 'Una región vitivinícola famosa por sus Malbecs.', 1),
('Maipú', 'Conocida por su larga tradición vinícola.', 1),
('Luján de Cuyo', 'Región destacada por la producción de Malbec de alta calidad.', 1),
('San Rafael', 'Zona vitivinícola reconocida por sus vinos tintos y espumosos.', 2),
('Valle del Elqui', 'Región en Chile conocida por su pisco y vinos.', 3),
('Colchagua', 'Área vinícola destacada por sus vinos tintos, especialmente Carmenere.', 3),
('Cachapoal', 'Región que produce vinos tintos intensos y complejos.', 3),
('Priorat', 'Región vinícola en Cataluña famosa por sus tintos con carácter.', 4),
('Ribera del Duero', 'Conocida por sus vinos tintos robustos, especialmente de Tempranillo.', 4),
('Rías Baixas', 'Región gallega famosa por sus vinos blancos Albariño.', 4),
('Valle de Casablanca', 'Región costera en Chile famosa por sus vinos blancos frescos.', 3),
('Rioja', 'Una de las regiones vinícolas más famosas de España, conocida por sus Tempranillos.', 4);

-- Inserción en la tabla bodegas
INSERT INTO bodegas (descripcion, historia, nombre, region_id) VALUES
('Bodega centenaria especializada en Malbec.', 'Fundada en 1900.', 'Bodeguita', 1),
('Pequeña bodega familiar en Maipú.', 'Con tradición de 50 años.', 'Bodegon', 2),
('Famosa por sus tintos intensos.', 'Fundada en 1985.', 'LaMarta', 4),
('Conocida por su pisco y vinos frescos.', 'Fundada en 1970.', 'Aberlour', 3),
('Productora de vinos blancos de alta gama.', 'Fundada en 1920.', 'OsRios', 5);


INSERT INTO tipos_uva (descripcion, nombre) VALUES
('Uva tinta popular en Argentina', 'Malbec'),
('Variedad ampliamente cultivada en todo el mundo', 'Cabernet Sauvignon'),
('Conocida por su suavidad y notas frutales', 'Merlot'),
('Uva con un sabor especiado y profundo', 'Syrah'),
('Uva blanca famosa por sus vinos frescos y crujientes', 'Chardonnay');


INSERT INTO varietales (descripcion, porcentaje_composicion, tipo_uva_id) VALUES
('Malbec 100%', 100.0, 1),
('Cabernet Sauvignon 80%', 80.0, 2),
('Merlot 60%', 60.0, 3),
('Syrah 100%', 100.0, 4),
('Chardonnay 100%', 100.0, 5);


-- Inserción de vinos con nombres aleatorios
INSERT INTO vinos (nombre, bodega_id, precio_ars) VALUES
('Malbec del Valle', 1, 3200.00),  -- Bodeguita, Varietal: Malbec
('Reserva Maipú', 2, 2500.00),     -- Bodegon, Varietal: Cabernet Sauvignon/Merlot
('Cielo Tinto', 4, 3800.00),       -- LaMarta, Varietal: Syrah
('Fresca Viña', 3, 2700.00),       -- Aberlour, Varietal: Chardonnay
('Brisa de Toscana', 5, 4200.00),  -- OsRios, Varietal: Chardonnay
('Gran Reserva Uco', 1, 5500.00),  -- Bodeguita, Varietal: Malbec
('Tinto del Sol', 2, 2900.00),     -- Bodegon, Varietal: Cabernet Sauvignon/Merlot
('Viña del Valle', 4, 4600.00),    -- LaMarta, Varietal: Syrah
('Frescor del Elqui', 3, 3100.00), -- Aberlour, Varietal: Chardonnay
('Borgoña Oscuro', 5, 5300.00),    -- OsRios, Varietal: Chardonnay
('Luján de Cuyo Clásico', 1, 4000.00),  -- Bodeguita, Varietal: Malbec
('Pescador del Valle', 2, 2300.00),    -- Bodegon, Varietal: Cabernet Sauvignon/Merlot
('Viña El Tesoro', 4, 3700.00),    -- LaMarta, Varietal: Syrah
('Cosecha de Altura', 3, 3400.00),  -- Aberlour, Varietal: Chardonnay
('Toscana Noble', 5, 4800.00);     -- OsRios, Varietal: Chardonnay


-- Inserción de reseñas
INSERT INTO reseñas (comentario, es_premium, fecha_reseña, puntaje, vino_id) VALUES
('Un Malbec con cuerpo y sabor afrutado. Ideal para una cena elegante.', TRUE, '2024-11-01', 4.8, 1),
('Vino suave y fácil de beber. Un buen acompañante para una comida ligera.', FALSE, '2024-10-30', 3.5, 2),
('El mejor Syrah que he probado, muy equilibrado y con una excelente persistencia.', TRUE, '2024-11-02', 4.9, 4),
('Agradable vino blanco, con una acidez refrescante y buen cuerpo. Muy recomendable.', FALSE, '2024-11-03', 4.0, 3),
('Excelente reserva, una joya de la vinicultura argentina. Perfecto para regalar.', TRUE, '2024-11-04', 5.0, 1),
('Vino elegante, con toques de frutas rojas y especias. Muy satisfactorio.', TRUE, '2024-11-05', 4.7, 2),
('Un vino que refleja su origen, con una gran armonía entre taninos y frutas.', FALSE, '2024-11-06', 4.2, 5),
('Muy buen tinto, ideal para disfrutar en una ocasión especial.', TRUE, '2024-11-07', 4.6, 4),
('Un Chardonnay con un buen balance de acidez y notas frutales. Ideal para maridar con mariscos.', FALSE, '2024-10-28', 3.8, 3),
('Una sorpresa, muy bien logrado para ser un vino joven. Me gustó mucho.', FALSE, '2024-11-08', 4.0, 2),
('Sutil y fresco, pero con un toque de complejidad. Muy recomendable para quienes aprecian los vinos blancos.', TRUE, '2024-10-29', 4.4, 3),
('Un vino con cuerpo y aromas profundos. Ideal para maridar con carnes rojas.', TRUE, '2024-11-09', 4.7, 5),
('Tinto muy bien logrado, con un excelente equilibrio. Lo recomiendo totalmente.', TRUE, '2024-10-31', 4.5, 1),
('Vino robusto y potente. Necesita más tiempo en botella para desarrollar su potencial.', FALSE, '2024-11-10', 3.2, 2),
('Suave y agradable, pero podría ser más complejo. Buena relación calidad-precio.', FALSE, '2024-11-11', 3.6, 5),
('Una experiencia sensorial única. Muy bien estructurado y con un final largo.', TRUE, '2024-11-12', 4.9, 4),
('Excelente vino de altura, ideal para los amantes de los tintos intensos.', TRUE, '2024-11-13', 4.8, 1),
('Un vino fresco y frutal, muy fácil de beber. Perfecto para compartir con amigos.', FALSE, '2024-11-14', 4.1, 3),
('Muy buen vino, aunque la acidez es un poco fuerte para mi gusto. Aún así lo recomiendo.', FALSE, '2024-11-15', 3.7, 2),
('Un vino muy versátil, se puede disfrutar en muchas ocasiones. Bien logrado.', TRUE, '2024-11-16', 4.6, 5),
('Un vino para los que buscan algo más suave y menos taninos. Ideal para iniciarse en el mundo de los tintos.', FALSE, '2024-11-17', 3.9, 4),
('Muy buen vino para acompañar carnes a la parrilla. Excelente relación calidad-precio.', TRUE, '2024-11-18', 4.4, 1),
('Vino agradable, aunque un poco más simple que otros. Cumple con su función.', FALSE, '2024-11-19', 3.3, 2),
('Una joya escondida. Sorprende por su complejidad y buen cuerpo.', TRUE, '2024-11-20', 4.9, 3),
('Este vino se merece un lugar destacado en cualquier bodega. De lo mejor que he probado.', TRUE, '2024-11-21', 5.0, 4),
('Bastante equilibrado y bien estructurado. Tiene mucho potencial, aunque aún es joven.', FALSE, '2024-11-22', 4.2, 5),
('Vino de gran cuerpo y mucho carácter. Ideal para una buena cena.', TRUE, '2024-11-23', 4.7, 1),
('Un Chardonnay suave con un toque dulce. Ideal para postres y platos ligeros.', FALSE, '2024-11-24', 4.1, 3),
('Vino de gran calidad, aunque tiene un precio elevado. Aún así, vale la pena.', TRUE, '2024-11-25', 4.8, 4),
('Vino con un buen balance de taninos, ideal para acompañar carnes rojas.', TRUE, '2024-11-26', 4.6, 5),
('Un vino excelente para regalar, especialmente si te gustan los tintos potentes.', TRUE, '2024-11-27', 4.9, 2),
('No me impresionó tanto como esperaba. Tiene buen sabor, pero algo plano.', FALSE, '2024-11-28', 3.5, 5),
('Siento que este vino podría mejorar con el tiempo. Aún así es bastante bueno.', FALSE, '2024-11-29', 3.8, 1),
('Frescor y notas cítricas que lo hacen único. Perfecto para maridar con pescado.', TRUE, '2024-11-30', 4.5, 3),
('Un vino elegante con notas de frutos rojos y especias. Muy bien logrado.', TRUE, '2024-12-01', 4.7, 4);
