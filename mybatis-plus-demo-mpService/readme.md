主要演示mybatis的AR模式、主键策略
#mybatis-plus:
#  mapper-locations:
#  - com/roy/mapper/*
#  #id策略全局配置
#  global-config:
#    db-config:
#      id-type: ID_WORKER
      # ignored,默认not null
      #field-strategy: not-empty
#  config-location:
#    classpath: mybatis-config.xml
#  #别名
#  type-aliases-package: com.roy.entity
#和config-location:不能同时出现
#  configuration:
#    map-underscore-to-camel-case: true
