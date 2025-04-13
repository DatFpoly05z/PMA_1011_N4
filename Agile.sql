CREATE DATABASE SalesManagement;
USE SalesManagement;

-- Bảng người dùng (Users)
CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL CHECK (role IN ('admin', 'staff', 'customer')),
    created_at DATETIME2 DEFAULT GETDATE()
);

-- Bảng danh mục sản phẩm (Categories)
CREATE TABLE Categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Bảng sản phẩm (Products)
CREATE TABLE Products (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT DEFAULT 0 NOT NULL,
    category_id INT NULL,
    created_at DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE SET NULL
);

-- Bảng đơn hàng (Orders)
CREATE TABLE Orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id INT NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('pending', 'processing', 'shipped', 'delivered', 'canceled')) DEFAULT 'pending',
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (customer_id) REFERENCES Users(id) ON DELETE CASCADE
);

-- Bảng chi tiết đơn hàng (OrderDetails)
CREATE TABLE OrderDetails (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    FOREIGN KEY (order_id) REFERENCES Orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Products(id) ON DELETE CASCADE
);

-- Bảng kho hàng (Inventory)
CREATE TABLE Inventory (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 0 CHECK (quantity >= 0),
    updated_at DATETIME2 DEFAULT GETDATE(),
    FOREIGN KEY (product_id) REFERENCES Products(id) ON DELETE CASCADE
);

-- Bảng thông báo (Notifications)
CREATE TABLE Notifications (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME2 DEFAULT GETDATE(),
    status VARCHAR(10) NOT NULL CHECK (status IN ('unread', 'read')) DEFAULT 'unread',
    FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
);

-- Bảng báo cáo doanh thu (Reports)
CREATE TABLE Reports (
    id INT IDENTITY(1,1) PRIMARY KEY,
    report_date DATE NOT NULL UNIQUE,
    total_orders INT NOT NULL DEFAULT 0 CHECK (total_orders >= 0),
    total_revenue DECIMAL(15,2) NOT NULL DEFAULT 0 CHECK (total_revenue >= 0)
);

-- Trigger để tự động cập nhật updated_at trong Orders
GO
CREATE TRIGGER trg_UpdateOrders
ON Orders
AFTER UPDATE
AS
BEGIN
    UPDATE Orders
    SET updated_at = GETDATE()
    WHERE id IN (SELECT id FROM inserted);
END;
GO

GO
CREATE TRIGGER trg_UpdateInventory
ON Inventory
AFTER UPDATE
AS
BEGIN
    UPDATE Inventory
    SET updated_at = GETDATE()
    WHERE id IN (SELECT id FROM inserted);
END;
GO

