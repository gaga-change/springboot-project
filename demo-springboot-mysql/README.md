# jpa + mysql 练习
> 单表操作。 以及多表操作（一对一，多对一，多对多）

## 场景

用户信息（user）

字段 | 注解
---|---
id | 
name | 姓名
age | 年龄
create_at | 创建时间 

车 （car）

字段 | 注解
---|---
id | 
user_id | 车主
car_num | 车牌号
create_at | 创建时间 

身份证（card）

字段 | 注解
---|---
id | 
user_id | 用户
card_num | 身份证号码
create_at | 创建时间

语言（language）

字段 | 注解
---|---
id | 
name | 语言名称

关系表（rel_user_language）
字段 | 注解
---|---
user_id | 
language_id | 



* 一个用户（user）拥有一个身份证（card）
* 一个用户（user）拥有多辆车（car）
* 一个用户（user）拥有多门语言（language）
* 一个语言（language）拥有多个用户（user）

## 需求

### 1. 创建一个用户（含其身份证、车、语言）

### 2. 修改一个用户（含其身份证、车、语言）

### 3. 删除一个用户 （级联）

### 4. 删除一个语言 （级联）


