select cast(abs(max(lat_n) - min(lat_n)) + abs(max(long_w) - min(long_w)) as decimal(10,4)) from station;
select top (1) convert(decimal(12,4), long_w) from station where lat_n > 38.7780 order by lat_n;
select cast(CEILING(avg(cast(salary as float)) - avg(cast(replace(salary,0,'') as float))) as int) from employees;