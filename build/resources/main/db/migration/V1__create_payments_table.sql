CREATE TABLE IF NOT EXISTS payments (
    id UUID PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_payments_customer_id ON payments(customer_id);
CREATE INDEX IF NOT EXISTS idx_payments_created_at ON payments(created_at);
