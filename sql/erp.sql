create table erp_product (
    product_id           bigint(20)      not null auto_increment    comment '产品ID',
    product_name         varchar(120)    not null            comment '调度名称',
    primary key (sched_name, job_name, job_group)
) engine=innodb comment = '任务详细信息表';