CREATE TABLE users (
                                     user_id SERIAL PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     email VARCHAR(255) UNIQUE NOT NULL,
                                     role VARCHAR(50) NOT NULL CHECK (Role IN ('USER', 'ADMINISTRATOR')),
                                     created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE orders (
                                      order_id SERIAL PRIMARY KEY,
                                      user_id INTEGER NOT NULL,
                                      order_number VARCHAR(255) UNIQUE NOT NULL,
                                      dispatch_city VARCHAR(255) NOT NULL,
                                      delivery_city VARCHAR(255) NOT NULL,
                                      status VARCHAR(50) NOT NULL CHECK (Status IN ('Pending', 'In Transit', 'Delivered', 'Cancelled')),
                                      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                      FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


CREATE TABLE cargo_details (
                                            detail_id SERIAL PRIMARY KEY,
                                            order_id INTEGER NOT NULL,
                                            weight DECIMAL(10, 2) NOT NULL,
                                            dimensions DECIMAL(10, 2) NOT NULL,
                                            created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                            updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                            FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);


CREATE TABLE cost_calculations (
                                                calculation_id SERIAL PRIMARY KEY,
                                                order_id INTEGER NOT NULL,
                                                base_cost DECIMAL(10, 2) NOT NULL,
                                                additional_fees DECIMAL(10, 2) NOT NULL,
                                                total_cost DECIMAL(10, 2) NOT NULL,
                                                created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                                updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                                FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);