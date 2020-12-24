# seata-springcloud-alibaba-nacos
seata分布式事务在springcloud alibaba+nacos上的应用

步骤1：启动nacos服务，创建好命名空间

步骤2：创建config.txt文件，存放在seata根目录

步骤3：配置seata/conf/registry.conf文件         

步骤4：使用nacos-config.sh 把配置项导入nacos配置中心

步骤5：微服务中的application.yml下列配置项
 seata:
  tx-service-group: my_test_tx_group
  
需要与config.txt中的下面配置项名称后缀保持一致

 service.vgroupMapping.my_test_tx_group=default

步骤6：启动seata服务

步骤7：启动所有微服务

