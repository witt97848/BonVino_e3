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

CREATE TABLE IF NOT EXISTS bodegas (
                                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                                       descripcion VARCHAR(255),
                                       historia VARCHAR(255),
                                       nombre VARCHAR(255),
                                       region_id INT NOT NULL,
                                       coordenadas_ubicacion VARCHAR(255),
                                       periodo_actualizacion VARCHAR(255),
                                       FOREIGN KEY (region_id) REFERENCES regiones_vitivinicolas(id)
);


CREATE TABLE IF NOT EXISTS vinos (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     nombre VARCHAR(255),
                                     bodega_id INT NOT NULL,
                                     precio_ars FLOAT,
                                     añada INT,
                                     imagen_etiqueta VARCHAR,
                                     nota_cata_bodega VARCHAR,
                                     FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
);


CREATE TABLE IF NOT EXISTS tipos_uva (
                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                                         descripcion VARCHAR(255),
                                         nombre VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS varietales (
                                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                                          descripcion VARCHAR(255),
                                          porcentaje_composicion FLOAT,
                                          tipo_uva_id INT,
                                          vino_id INT,
                                          FOREIGN KEY (tipo_uva_id) REFERENCES tipos_uva(id)
                                              FOREIGN KEY (vino_id) REFERENCES vinos(id)
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

-- Inserción de bodegas con los nuevos campos: coordenadas_ubicacion y periodo_actualizacion
INSERT INTO bodegas (descripcion, historia, nombre, region_id, coordenadas_ubicacion, periodo_actualizacion) VALUES
                                                                                                                 ('Bodega centenaria especializada en Malbec.', 'Fundada en 1900.', 'Bodeguita', 1, '-33.12345, -68.45678', 'Anual'),
                                                                                                                 ('Pequeña bodega familiar en Maipú.', 'Con tradición de 50 años.', 'Bodegon', 2, '-32.87654, -68.23456', 'Semestral'),
                                                                                                                 ('Famosa por sus tintos intensos.', 'Fundada en 1985.', 'LaMarta', 4, '-34.12345, -69.87654', 'Mensual'),
                                                                                                                 ('Conocida por su pisco y vinos frescos.', 'Fundada en 1970.', 'Aberlour', 3, '-33.98765, -70.12345', 'Trimestral'),
                                                                                                                 ('Productora de vinos blancos de alta gama.', 'Fundada en 1920.', 'OsRios', 5, '-31.54321, -68.54321', 'Anual');

-- Inserción de vinos con nuevos campos: añada, imagen_etiqueta, y nota_cata_bodega
INSERT INTO vinos (nombre, bodega_id, precio_ars, añada, imagen_etiqueta, nota_cata_bodega) VALUES
                                                                                                ('Malbec del Valle', 1, 3200.00, 2019, 'https://example.com/malbec_del_valle.jpg', 'Aromas intensos de frutos rojos y especias. Final persistente.'),
                                                                                                ('Reserva Maipú', 2, 2500.00, 2020, 'https://example.com/reserva_maipu.jpg', 'Suave en boca, con toques de frutos secos y chocolate amargo.'),
                                                                                                ('Cielo Tinto', 4, 3800.00, 2021, 'https://example.com/cielo_tinto.jpg', 'Cuerpo robusto con notas de ciruela y pimienta negra.'),
                                                                                                ('Fresca Viña', 3, 2700.00, 2020, 'https://example.com/fresca_vina.jpg', 'Fresco y vivaz, con notas cítricas y herbales. Perfecto para mariscos.'),
                                                                                                ('Brisa de Toscana', 5, 4200.00, 2018, 'https://example.com/brisa_de_toscana.jpg', 'Elegante, con notas de manzana verde y almendras tostadas.'),
                                                                                                ('Gran Reserva Uco', 1, 5500.00, 2019, 'https://example.com/gran_reserva_uco.jpg', 'Complejo y estructurado, con aromas a frutos negros y tabaco.'),
                                                                                                ('Tinto del Sol', 2, 2900.00, 2021, 'https://example.com/tinto_del_sol.jpg', 'Frutal y redondo en boca, ideal para acompañar carnes rojas.'),
                                                                                                ('Viña del Valle', 4, 4600.00, 2020, 'https://example.com/vina_del_valle.jpg', 'Notas de frambuesa y especias, con taninos suaves y redondos.'),
                                                                                                ('Frescor del Elqui', 3, 3100.00, 2022, 'https://example.com/frescor_del_elqui.jpg', 'Refrescante y mineral, con toques cítricos que resaltan en boca.'),
                                                                                                ('Borgoña Oscuro', 5, 5300.00, 2019, 'https://example.com/borgona_oscuro.jpg', 'Cuerpo potente con taninos firmes y notas de frutos negros.'),
                                                                                                ('Luján de Cuyo Clásico', 1, 4000.00, 2018, 'https://example.com/lujan_de_cuyo_clasico.jpg', 'Robusto y aromático, con presencia de frutos del bosque y especias.'),
                                                                                                ('Pescador del Valle', 2, 2300.00, 2022, 'https://example.com/pescador_del_valle.jpg', 'Ligeramente frutal, con un toque de acidez y frescura.'),
                                                                                                ('Viña El Tesoro', 4, 3700.00, 2021, 'https://example.com/vina_el_tesoro.jpg', 'Profundo y elegante, con aromas a frutos rojos y vainilla.'),
                                                                                                ('Cosecha de Altura', 3, 3400.00, 2020, 'https://example.com/cosecha_de_altura.jpg', 'Equilibrado con notas de frutos tropicales y un toque de roble.'),
                                                                                                ('Toscana Noble', 5, 4800.00, 2019, 'https://example.com/toscana_noble.jpg', 'Complejo y redondo en boca, con sabores a ciruela y chocolate.');

INSERT INTO tipos_uva (descripcion, nombre) VALUES
                                                ('Uva tinta popular en Argentina', 'Malbec'),
                                                ('Variedad ampliamente cultivada en todo el mundo', 'Cabernet Sauvignon'),
                                                ('Conocida por su suavidad y notas frutales', 'Merlot'),
                                                ('Uva con un sabor especiado y profundo', 'Syrah'),
                                                ('Uva blanca famosa por sus vinos frescos y crujientes', 'Chardonnay');

INSERT INTO varietales (descripcion, porcentaje_composicion, tipo_uva_id, vino_id) VALUES
                                                                                       ('Malbec 100%', 100.0, 1, 1),
                                                                                       ('Cabernet Sauvignon 80%', 80.0, 2, 2),
                                                                                       ('Merlot 60%', 60.0, 3, 3),
                                                                                       ('Syrah 100%', 100.0, 4, 4),
                                                                                       ('Chardonnay 100%', 100.0, 5, 5),
                                                                                       ('Malbec y Syrah 50%/50%', 50.0, 1, 6),
                                                                                       ('Cabernet Sauvignon y Merlot 70%/30%', 70.0, 2, 7),
                                                                                       ('Pinot Noir 100%', 100.0, 4, 8),
                                                                                       ('Sauvignon Blanc 100%', 100.0, 2, 9),
                                                                                       ('Malbec 75%', 75.0, 1, 10),
                                                                                       ('Tempranillo 100%', 100.0, 3, 11),
                                                                                       ('Syrah y Tempranillo 60%/40%', 60.0, 4, 12),
                                                                                       ('Cabernet Franc 100%', 100.0, 1, 13),
                                                                                       ('Petit Verdot 100%', 100.0, 5, 14),
                                                                                       ('Malbec y Cabernet Sauvignon 50%/50%', 50.0, 1, 15),
                                                                                       ('Chardonnay y Viognier 80%/20%', 80.0, 5, 1),
                                                                                       ('Merlot y Petit Verdot 60%/40%', 60.0, 3, 2),
                                                                                       ('Tannat 100%', 100.0, 3, 3),
                                                                                       ('Pinot Grigio 100%', 100.0, 2, 4),
                                                                                       ('Zinfandel 100%', 100.0, 4, 5);

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
                                                                                 ('Un vino elegante con notas de frutos rojos y especias. Muy bien logrado.', TRUE, '2024-12-01', 4.7, 4),
                                                                                 ('Un vino suave y equilibrado, perfecto para acompañar pastas.', FALSE, '2024-12-02', 4.0, 6),
                                                                                 ('Me encantaron las notas de chocolate y café. Un vino robusto y elegante.', TRUE, '2024-12-03', 4.7, 7),
                                                                                 ('Un poco ácido para mi gusto, pero bien estructurado.', FALSE, '2024-12-04', 3.2, 8),
                                                                                 ('Gran calidad en relación con su precio. Muy recomendable.', TRUE, '2024-12-05', 4.6, 9),
                                                                                 ('Ideal para ocasiones especiales. Tiene un sabor persistente.', TRUE, '2024-12-06', 4.9, 10),
                                                                                 ('Un vino complejo con sabores a madera y frutos secos.', FALSE, '2024-12-07', 3.9, 11),
                                                                                 ('Perfecto para acompañar una cena de amigos. Muy versátil.', TRUE, '2024-12-08', 4.4, 12),
                                                                                 ('El aroma es excelente, aunque el sabor podría mejorar.', FALSE, '2024-12-09', 3.5, 13),
                                                                                 ('Un tinto con buena presencia y un toque picante.', TRUE, '2024-12-10', 4.5, 14),
                                                                                 ('Un vino joven, ideal para quienes empiezan en el mundo del vino.', FALSE, '2024-12-11', 3.8, 15),
                                                                                 ('Muy suave, casi imperceptible. Agradable pero le falta cuerpo.', FALSE, '2024-12-12', 3.1, 6),
                                                                                 ('De los mejores tintos que he probado este año. Recomiendo al 100%.', TRUE, '2024-12-13', 4.9, 7),
                                                                                 ('Notas dulces y un final largo en boca. Muy recomendable.', TRUE, '2024-12-14', 4.8, 8),
                                                                                 ('Demasiado intenso para mi gusto, pero de buena calidad.', FALSE, '2024-12-15', 3.7, 9),
                                                                                 ('Tiene buena acidez y un sabor refrescante. Ideal para verano.', TRUE, '2024-12-16', 4.3, 10),
                                                                                 ('Muy bien estructurado, con notas de frutos negros. Un vino complejo.', TRUE, '2024-12-17', 4.7, 11),
                                                                                 ('El mejor vino de esta bodega. Vale la pena el precio.', TRUE, '2024-12-18', 4.9, 12),
                                                                                 ('Buen vino, pero podría mejorar en su final.', FALSE, '2024-12-19', 3.6, 13),
                                                                                 ('Aromas de frutos rojos y un toque floral. Muy agradable.', TRUE, '2024-12-20', 4.4, 14),
                                                                                 ('Sabor ligero y refrescante, perfecto para climas cálidos.', FALSE, '2024-12-21', 3.9, 15),
                                                                                 ('Un vino bastante interesante, pero esperaba más intensidad.', FALSE, '2024-12-22', 3.4, 6),
                                                                                 ('Buen equilibrio entre dulzor y acidez. Ideal para postres.', TRUE, '2024-12-23', 4.5, 7),
                                                                                 ('Excelente calidad por su precio. Perfecto para reuniones.', TRUE, '2024-12-24', 4.6, 8),
                                                                                 ('Un sabor algo amargo, pero agradable para un vino joven.', FALSE, '2024-12-25', 3.3, 9),
                                                                                 ('Sabores frutales intensos con un toque de especias.', TRUE, '2024-12-26', 4.8, 10),
                                                                                 ('Un vino que sorprende en cada sorbo. Muy bien hecho.', TRUE, '2024-12-27', 4.9, 11),
                                                                                 ('Esperaba un sabor más robusto, pero es bueno para su precio.', FALSE, '2024-12-28', 3.6, 12),
                                                                                 ('Me encanta su frescura y su aroma. Es un vino muy versátil.', TRUE, '2024-12-29', 4.3, 13),
                                                                                 ('Ligero y refrescante, ideal para una tarde soleada.', FALSE, '2024-12-30', 3.8, 14),
                                                                                 ('Un vino que destaca en aromas y en sabor. Muy recomendable.', TRUE, '2024-12-31', 4.7, 15);


