CREATE TABLE ticket (
    id UUID PRIMARY KEY,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP,
    status VARCHAR(255)
);

INSERT INTO ticket (id, fecha_creacion, fecha_modificacion, status)
VALUES
('a8098c1a-f86e-11da-bd1a-00112444be1e', '2024-08-01 12:34:56', '2024-08-01 13:34:56', 'abierto'),
('b8098c1a-f86e-11da-bd1a-00112444be1f', '2024-08-02 14:00:00', '2024-08-02 15:00:00', 'abierto'),
('c8098c1a-f86e-11da-bd1a-00112444be2e', '2024-08-03 16:00:00', '2024-08-03 17:00:00', 'cerrado');

CREATE TABLE users (
    login VARCHAR(255) PRIMARY KEY,
    id BIGINT NOT NULL,
    node_id VARCHAR(255),
    avatar_url VARCHAR(255),
    gravatar_id VARCHAR(255),
    url VARCHAR(255),
    html_url VARCHAR(255),
    followers_url VARCHAR(255),
    following_url VARCHAR(255),
    gists_url VARCHAR(255),
    starred_url VARCHAR(255),
    subscriptions_url VARCHAR(255),
    organizations_url VARCHAR(255),
    repos_url VARCHAR(255),
    events_url VARCHAR(255),
    received_events_url VARCHAR(255),
    type VARCHAR(50),
    site_admin BOOLEAN,
    score FLOAT8
);