# Quản Lý Sân Bay ✈️

## Giới thiệu
Hệ thống quản lý sân bay giúp theo dõi thông tin khách hàng, chuyến bay, vé bay và ghế ngồi trên máy bay.

## Mô hình dữ liệu

### 1. Khách hàng
- **Mã khách hàng**: Mã định danh duy nhất cho mỗi khách hàng. (Kh + Mã khách hàng 6 số)
- **Họ tên**: Họ và tên đầy đủ của khách hàng.
- **Ngày sinh**: Ngày/tháng/năm sinh. 
- **Giới tính**: Nam/Nữ. 
- **Số điện thoại**: Số liên lạc của khách hàng.
- **Địa chỉ**: Địa chỉ cư trú.
- **CCCD**: Căn cước công dân hoặc CMND.
- **Quốc tịch**: Quốc gia của khách hàng.

### 2. Chuyến bay
- **Mã chuyến bay**: Mã định danh của chuyến bay. 
- **Hãng bay**: Hãng hàng không vận hành chuyến bay.
- **Điểm đến**: Nơi hạ cánh.
- **Điểm đi**: Nơi khởi hành.
- **Thời gian bay**: Thời gian cất cánh.
- **Thời gian hạ cánh**: Dự kiến thời gian hạ cánh.
- **Trạng thái chuyến bay**: Trạng thái hiện tại (Bị hoãn, Đã khởi hành, Đang bay, Dự kiến, Đã chuyển hướng, Đang phục hồi, Đã hạ cánh, Đã đến, Đã hủy, Chuyến bay đã qua.).

### 3. Vé bay
- **Mã vé bay**: Mã định danh của vé. 
- **Mã khách hàng**: Liên kết đến khách hàng sở hữu vé.
- **Số ghế**: Ghế ngồi trên chuyến bay. (Dãy ghế + số ghế)
- **Cổng bay**: Cổng lên máy bay. 
- **Địa điểm bay**: Nơi khởi hành. 
- **Thời gian bay**: Thời gian cất cánh.

### 4. Ghế
- **Dãy ghế**: Khu vực ghế trên máy bay.
- **Số ghế**: Số thứ tự ghế.
- **Máy bay**: Mã máy bay chứa ghế này.

### 5. Sân bay
- **Mã sân bay**: Mã định danh của sân bay.
- **Tên sân bay**: Tên chính thức của sân bay.
- **Địa chỉ**: Vị trí sân bay.
- **Thành phố**: Thành phố nơi sân bay hoạt động.
- **Quốc gia**: Quốc gia sân bay thuộc về.
- **Mã IATA**: Mã sân bay theo chuẩn quốc tế.
- **Số đường băng**: Số lượng đường băng phục vụ cất/hạ cánh.

## Controller - Quản lý thông tin

### 1. Tìm kiếm, chỉnh sửa và thêm thông tin khách hàng
- **Tìm kiếm**: `/api/customers/search?q={query}`
- **Chỉnh sửa**: `/api/customers/update/{id}`
- **Thêm mới**: `/api/customers/create`

### 2. Tìm kiếm, chỉnh sửa và thêm thông tin chuyến bay
- **Tìm kiếm**: `/api/flights/search?q={query}`
- **Chỉnh sửa**: `/api/flights/update/{id}`
- **Thêm mới**: `/api/flights/create`

### 3. Tìm kiếm, chỉnh sửa và thêm thông tin vé bay
- **Tìm kiếm**: `/api/tickets/search?q={query}`
- **Chỉnh sửa**: `/api/tickets/update/{id}`
- **Thêm mới**: `/api/tickets/create`

### 4. Tìm kiếm thông tin ghế
- **Tìm kiếm**: `/api/seats/search?q={query}`

## Hướng dẫn sử dụng
1. Thêm thông tin khách hàng.
2. Quản lý danh sách chuyến bay.
3. Đặt vé và chỉ định ghế ngồi cho khách hàng.
4. Cập nhật trạng thái chuyến bay theo thời gian thực.
5. Tìm kiếm, chỉnh sửa và thêm mới thông tin nhanh chóng qua API.

---

📌 *Liên hệ hỗ trợ nếu có thắc mắc!* 🚀

