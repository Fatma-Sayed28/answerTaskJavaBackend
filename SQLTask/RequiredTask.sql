use `databaseschema`;
select user.user_id ,user.username, training_details.training_id, training_details.training_date, count(training_details.training_id) as count
from user inner join  training_details
on user.user_id =training_details.user_id 
group by training_details.training_id,user.user_id,training_details.training_date
having count(training_details.training_id)>=2 order by training_details.training_date desc;