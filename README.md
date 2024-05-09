# EnocaJavaChallenge

Projede ilk olarak bir MySql tablosu ve bu tabloda ki entityler için Entity paketi oluturuldu:
- Cart: Id, CustomerId, CartItem, TotalPrice gibi sepet bilgilerini tutuyor.
  CustomerId -> Hangi müşterinin sepet bilgisi olduğunu öğrenmemiz için tutuluyor.
  CartItem -> Müşterinin sepete eklediği ürünlerin bilgisini tutan başka bir tablo bir Cartta birden çok CartItem olabilir.
  TotalPrice -> sepettin toplam fiyat bilgisi.
- CartItem: Id, CartId, ProductId, Quantity değişkenlerini tutuyor.
  CartId -> bu CartItem hangi Cart'a ait olduğu bilgisi.
  ProductId -> bu CartItem hangi Product'ı içeriyor oluduğunun bilgisi.
  Quantity -> bu üründen sepete ne kadar eklendiğinin bilgisi.
- Customer: Id, Name, Surname değişkenlerini tutuyor.
  Name -> Müşteri ismi bilgisi.
  Surname -> Müşteri Soyismi bilgisi.
- Order: CustomerId, CartItem, TotalPrice değişkenlerini tutuyor.
  CustomerId -> bu siparişin hangi müşteriye ait olduğu bilgisi
  CartItem -> sipariş içeriğinin bilgisi.
  TotalPrice -> Siparişin toplam fiyat bilgisi.
- OrderHistory: Customer, CartItem, TotalPrice değişkenlerini tutuyor.
  CustomerId -> Hangi müşterinin sipariş geçmişi olduğunun bilgisi.
  CartItem -> Sipariş içeriği bilgisi.
  TotalPrice -> toplam sipariş fiyatı.
- Product: Stock, Price, Name değişkenlerini tutuyor.
  Stock -> Bu ürünün stok sayısı bilgisi.
  Price -> ürünün fiyat bilgisi.
  Name -> ürünün adı.
- BaseEntity: Tüm entitiylerde ortak olan id bilgisini tutuyor ve tüm entityler bu entity'yı miras alıyor.

İkinci olarak projede Data Access katmanı oluşturuldu ve bu katmanda tüm entityler için Interface oluşturuldu, interface oluşturmamızın sebebi ileride başka bir ORM teknolojisine hızlı bir şekilde geçebilmek için şuanda kullandığım ORM Hibernate ile MySqlden tabloların bilgisi ve tabloya veri ekleme silme güncelleme işleri yapıldı.

Servis katmanında 

