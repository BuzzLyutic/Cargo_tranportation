CREATE TABLE Users (
                       UserID SERIAL PRIMARY KEY,
                       Username VARCHAR(255) NOT NULL,
                       Password VARCHAR(255) NOT NULL,
                       Email VARCHAR(255) UNIQUE NOT NULL,
                       Role VARCHAR(50) NOT NULL CHECK (Role IN ('User', 'Administrator')),
                       CreatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       UpdatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Orders (
                        OrderID SERIAL PRIMARY KEY,
                        UserID INTEGER NOT NULL,
                        OrderNumber VARCHAR(255) UNIQUE NOT NULL,
                        DispatchCity VARCHAR(255) NOT NULL,
                        DeliveryCity VARCHAR(255) NOT NULL,
                        Status VARCHAR(50) NOT NULL CHECK (Status IN ('Pending', 'In Transit', 'Delivered', 'Cancelled')),
                        CreatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                        UpdatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE CargoDetails (
                              DetailID SERIAL PRIMARY KEY,
                              OrderID INTEGER NOT NULL,
                              Weight DECIMAL(10, 2) NOT NULL,
                              Dimensions VARCHAR(255) NOT NULL,
                              CreatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                              UpdatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

CREATE TABLE CostCalculations (
                                  CalculationID SERIAL PRIMARY KEY,
                                  OrderID INTEGER NOT NULL,
                                  BaseCost DECIMAL(10, 2) NOT NULL,
                                  AdditionalFees DECIMAL(10, 2) NOT NULL,
                                  TotalCost DECIMAL(10, 2) NOT NULL,
                                  CreatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                  UpdatedAt TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);
