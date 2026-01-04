-- Enable pg_stat_statements for query monitoring (requires shared_preload_libraries already set)
CREATE EXTENSION IF NOT EXISTS pg_stat_statements;

-- Optional but commonly useful
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Create a read-only monitoring user for postgres_exporter
DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'exporter') THEN
    CREATE ROLE exporter WITH LOGIN PASSWORD 'exporter_password_change_me';
  END IF;
END$$;

-- Grant minimum perms for metrics
GRANT CONNECT ON DATABASE appdb TO exporter;
GRANT USAGE ON SCHEMA public TO exporter;
GRANT pg_monitor TO exporter;
