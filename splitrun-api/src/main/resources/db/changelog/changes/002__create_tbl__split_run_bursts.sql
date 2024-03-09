CREATE TABLE public.split_run_bursts (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

  split_run_id BIGINT,

  burst_number INTEGER NOT NULL,

  json_config JSONB NOT NULL,

  dashboard_name VARCHAR(100) NULL,

  storage_folder TEXT NULL,

  executed_at TIMESTAMP WITH TIME ZONE NULL,
  executed_by VARCHAR(50) NULL,

  -- Audit columns
  customer_id VARCHAR(50) NOT NULL,
  user_id VARCHAR(50) NOT NULL,

  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by VARCHAR(50) NOT NULL,

  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_by VARCHAR(50) NOT NULL,

  deleted_at TIMESTAMP WITH TIME ZONE NULL,
  deleted_by VARCHAR(50) NULL,

  -- Constraints
  FOREIGN KEY (split_run_id) REFERENCES split_runs(id)

);
