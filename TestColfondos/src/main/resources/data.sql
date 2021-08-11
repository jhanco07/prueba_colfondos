DROP TABLE IF EXISTS tipo_documento;

CREATE TABLE tipo_documento (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tipo VARCHAR(5) NOT NULL
);

INSERT INTO tipo_documento (tipo) VALUES
  ('CC'),
  ('CE'),
  ('NIT');