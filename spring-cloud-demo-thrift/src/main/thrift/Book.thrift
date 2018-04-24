namespace java demo.thrift

struct Book {
    1: i64 id;
    2: string title;
    3: string author;
    4: i32 pages;
    5: string publishDate;
}

service BookService {
  Book getBook(1:i64 id);
}
