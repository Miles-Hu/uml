spring3.0已经不再支持jtom了，不过我们可以用第三方开源软件atomikos(http://www.atomikos.com/)来实现． 

Atomikos是目前在分布式事务管理中做得相当不错的开源软件。
有10年以上的经验,Atomikos保障您的关键事务和防止昂贵的数据丢失在发生系统故障或事故中．
Atomikos支持XA(全局事务)和NON-XA(非全局事务)，NON-XA效率高 于XA.

本文主要是讲XA事件,因为要在不同的数据库中操作多张表． 
