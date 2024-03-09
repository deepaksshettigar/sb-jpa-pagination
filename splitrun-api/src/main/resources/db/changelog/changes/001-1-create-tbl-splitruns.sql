CREATE TABLE public.split_run (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  is_active BOOLEAN NOT NULL DEFAULT true,

  customer_id VARCHAR(50) NOT NULL,
  user_id VARCHAR(50) NOT NULL,

  name VARCHAR(255) NOT NULL,

  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by VARCHAR(50) NOT NULL,

  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_by VARCHAR(50) NOT NULL,

  deleted_at TIMESTAMP WITH TIME ZONE NULL,
  deleted_by VARCHAR(50) NULL--,

  --CONSTRAINT split_run_id__pk PRIMARY KEY (id)

);