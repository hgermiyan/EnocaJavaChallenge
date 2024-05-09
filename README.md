# EnocaJavaChallenge
# Proje Yapısı
Proje aşağıdaki katmanlardan oluşmaktadır:

Entity: Veritabanı tablolarına karşılık gelen model sınıflarını içerir.

Data Access: Veritabanı ile etkileşimi sağlayan arayüzleri ve somut sınıfları içerir.

Service: İş mantığını ve işlevselliği sağlayan sınıfları içerir.
Veritabanı Tabloları

# Proje aşağıdaki veritabanı tablolarını kullanmaktadır:

Cart: Müşterinin sepet bilgilerini tutar.

CartItem: Sepetteki ürünlerin bilgilerini tutar.

Customer: Müşteri bilgilerini tutar.

Order: Sipariş bilgilerini tutar.

OrderHistory: Geçmiş sipariş bilgilerini tutar.

Product: Ürün bilgilerini tutar.

BaseEntity: Tüm entityler için ortak ID bilgisini tutar.

# Data Access Katmanı
Data Access katmanı, veritabanı ile etkileşimi sağlayan arayüzleri ve somut sınıfları içerir. Arayüzler, ileride başka bir ORM teknolojisine geçmeyi kolaylaştırmak için tanımlanmıştır. Somut sınıflar ise Hibernate ORM ile MySQL veritabanına erişimi sağlar.

# Servis Katmanı
Servis katmanı, iş mantığını ve işlevselliği sağlayan sınıfları içerir. Bu katmanda aşağıdaki servisler bulunur:

CartService: Sepet ile ilgili işlemleri gerçekleştirir.

CustomerService: Müşteriler ile ilgili işlemleri gerçekleştirir.

OrderService: Siparişler ile ilgili işlemleri gerçekleştirir.

# Servis İşlevleri
Servis fonksiyonlarının detayları aşağıdaki gibidir:

# CartService:
getCart(Long cartId): Belirtilen ID'ye sahip sepeti getirir.

updateCart(Cart cart): Sepeti günceller.

emptyCart(Long cartId): Belirtilen ID'ye sahip sepeti boşaltır.

addProductToCart(Long customerId, Product product, int quantity): Belirtilen müşteriye ve ürüne ait sepet öğesini ekler veya günceller.

removeProductFromCart(Long customerId, Product product): Belirtilen müşteriye ve ürüne ait sepet öğesini siler.
# CustomerService:
createCustomer(Customer customer): Yeni bir müşteri oluşturur.
# OrderService:
getOrderForCode(long orderId): Belirtilen id'ye sahip siparişi getirir.

getAllOrdersForCustomer(Long customerId): Belirtilen müşteriye ait tüm siparişleri getirir.

placeOrder(Cart cart): Sepeti siparişe dönüştürür ve sipariş geçmişine kaydeder. Sepet boşaltılır.
# ProductService:
getProduct: ürünü getirir.

createProduct: ürün ekler.

updateProduct: ürünü günceller.

deleteProduct: ürünü siler.
# Sonuç
Enoca firmasının vermiş olduğu JavaChallenge, MySQL veritabanında depolanan ürünler ve siparişler ile ilgili işlemleri gerçekleştirmek için Java ve Spring Boot framework'ü kullanmaktadır. Proje, katmanlı bir mimariye sahiptir ve her katmanın sorumlulukları net bir şekilde tanımlanmıştır. Data Access katmanı, veritabanı ile etkileşimi sağlamak için Hibernate ORM'u kullanır. Servis katmanı ise iş mantığını ve işlevselliği sağlayan sınıfları içerir.
