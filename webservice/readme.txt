客户端代码写完后启动
进入jdk  bin目录
借用jdk的wsimport 命令来生成辅助调用代码执行如下命令
wsimport -keep wsimport -keep http://localhost:9112/Businessimpl?wsdl
地址即服务端的发布地址
执行后会在当前目录下生成business\service\webservice\night\com\client.java 和 Businessimpl.java
基于这两个代码在客户端调用
test里面客户端代码调用