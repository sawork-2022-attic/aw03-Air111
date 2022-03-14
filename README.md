# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .

---

And please elaborate your understanding in MVC architecture via this homework in your README.md.

在本次作业中，展示界面不再直接与服务`PosService`交互，而是经过控制器`PosController`，它作为视图与数据的桥梁，视图不能越过它获取数据，数据也不能越过它向视图传递信息。这是一种"Fat Servers"的设计，它保证了后端数据的安全性，同时便于更改操作在后端的实现方式

由于业务层和数据库都实现在控制器`PosController`之后的后端，它们实际上合并起来作为一个model，对外提供对数据操作的接口

## 实现功能

实现以下按钮的响应：

左侧区域的"Add"，右侧区域的"+", "-", "Cancel"，垃圾桶（删除）键

实现商品名称和价格以及Total的正确显示