insert into jpa_provider (name, created_at)
values ('A주류', now()),
       ('B유통', now()),
       ('C종합유통', now());

insert into jpa_product (name, price, stock, provider_id, created_at)
values ('코카콜라', 1500, 100, 1, now()),
       ('칠성사이다', 1300, 100, 1, now()),
       ('코카콜라제로', 1400, 50, 1, now()),
       ('칠성사이다제로', 1200, 300, 1, now()),
       ('삼각김밥', 1000, 5, 3, now()),
       ('육개장사발면', 1000, 20, 2, now()),
       ('새우탕면', 1300, 10, 2, now()),
       ('진짬뽕', 1600, 5, 2, now()),
       ('백종원 도시락', 5000, 2, 3, now()),
       ('김혜자 도시락', 6000, 3, 3, now());