-- question 1
select p.* 
from persons p
left join stakeholders s on p.pid = s.pid
where domain = 'public';

-- question 2
select p.*
from persons p
left join stakeholders s on p.pid = s.pid
where domain is not null
and p.pid in (
	select pid 
	from CommentsOrSuggestions
	group by pid 
	having count(*) > 5
);

-- question 3
select p.* 
from persons p
left join graduate g on p.pid = g.pid
where g.pid is not null
and g.pid in (
	select GraduatePID from Supervise group by GraduatePID having count(distinct ProfPID) >= 2
) and g.pid in (
	select GraduatePID from Assign group by GraduatePID having count(concat(LabName, LabSchool)) >= 2
);

-- question 4
select p.*
from persons p
left join Professors prof on p.pid = prof.pid
where prof.pid is not null
and p.pid in (
	select PID from TeachingSessionR1 group by PID having count(distinct timestamp) >= 2
);

-- question 5
select lab1.LabName, lab2.EqName
from LaboratoryEquipment1 lab1
left join LaboratoryEquipment2 lab2 on lab1.ModelNo = lab2.ModelNo

-- question 6
select p.*
from persons p
left join Undergraduate u on p.pid = u.PID
where u.PID is not null
and p.pid not in (select UndergraduatePID from ExperimentSession);

-- question 7
select p.*
from persons p
left join graduate g on p.pid = g.pid
where g.pid is not null
and p.pid in (select graduatepid from Assign)
and p.pid in (select pid from AttendR1);
