## 本项目实现的最终作用是基于SSH羽毛球馆管理系统
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 会员管理
 - 器材管理
 - 收银员管理
 - 教练管理
 - 球场管理
 - 管理员登录
 - 订单管理
### 第2个角色为收银员角色，实现了如下功能：
 - 会员查看和充值
 - 器材查看管理
 - 收银员登录
 - 教练查看
 - 球场场地查看
 - 订单管理
### 第3个角色为用户角色，实现了如下功能：
 - 查看个人信息
 - 查看我的订单
 - 用户登录
 - 预订球场
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_ymqg_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [app](#app) |  |
| [area](#area) |  |
| [cashier](#cashier) |  |
| [coach](#coach) |  |
| [equip](#equip) |  |
| [manage](#manage) |  |
| [message](#message) | 留言信息表 |
| [myorder](#myorder) |  |
| [news](#news) | 新闻资讯表 |
| [t_user](#t_user) | 用户表 |
| [zi_liao](#zi_liao) |  |

**表名：** <a id="app">app</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | app |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  4   | pic |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图片  |
|  5   | pic1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | pic2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | pic3 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | pic4 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | pic5 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | TYPE |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |

**表名：** <a id="area">area</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | price |   int   | 10 |   0    |    N     |  N   |       | 价格  |
|  3   | state |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  4   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  5   | useState |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="cashier">cashier</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  3   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  4   | sex |   int   | 10 |   0    |    Y     |  N   |   NULL    | 性别  |
|  5   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |

**表名：** <a id="coach">coach</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | age |   int   | 10 |   0    |    Y     |  N   |   NULL    | 年龄  |
|  3   | level |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  5   | price |   int   | 10 |   0    |    Y     |  N   |   NULL    | 价格  |
|  6   | sex |   int   | 10 |   0    |    Y     |  N   |   NULL    | 性别  |
|  7   | state |   int   | 10 |   0    |    Y     |  N   |   NULL    | 状态  |

**表名：** <a id="equip">equip</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | price |   int   | 10 |   0    |    Y     |  N   |   NULL    | 价格  |
|  4   | type |   int   | 10 |   0    |    Y     |  N   |   NULL    | 类型  |
|  5   | state |   int   | 10 |   0    |    Y     |  N   |   NULL    | 状态  |

**表名：** <a id="manage">manage</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | key |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  6   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |

**表名：** <a id="message">message</a>

**说明：** 留言信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | isDelete |   int   | 10 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  4   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  5   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="myorder">myorder</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | code |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | state |   int   | 10 |   0    |    Y     |  N   |   NULL    | 状态  |
|  4   | time |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 时间  |
|  5   | areaId |   int   | 10 |   0    |    Y     |  N   |   NULL    | 地区ID  |
|  6   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  7   | consume |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="news">news</a>

**说明：** 新闻资讯表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  3   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | isDelete |   int   | 10 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  5   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  6   | type |   int   | 10 |   0    |    Y     |  N   |   NULL    | 类型  |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  4   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  6   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  7   | sex |   int   | 10 |   0    |    N     |  N   |       | 性别  |
|  8   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  9   | brithday |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  10   | level |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  11   | ye |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="zi_liao">zi_liao</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  3   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  4   | url |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 网络地址  |
|  5   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  6   | url2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

