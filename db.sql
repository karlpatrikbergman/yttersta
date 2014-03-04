
-- Band table --
create sequence band_id_seq;
create table band
(
  id int primary key not null default nextval('band_id_seq'),
  name varchar(50),
  description varchar(255)

);

insert into band (name, description) values ('Accept', 'With their brutal, simple riffs and aggressive, fast tempos, Accept were one of the top metal bands of the early ''80s, and a major influence on the development of thrash');
insert into band (name, description) values ('Judas Priest', 'Judas Priest was one of the most influential heavy metal bands of the ''70s, spearheading the New Wave of British Heavy Metal late in the decade.');
insert into band (name, description) values ('Iron Maiden', 'Known for such powerful hits as "Two Minutes to Midnight" and "The Trooper," Iron Maiden were and are one of the most influential bands of the heavy metal genre.');
select * from band;

-- Musician table --
create sequence musician_id_seq;
create table musician
(
  id int primary key not null default nextval('musician_id_seq'),
  firstname varchar(50),
  lastname varchar(50),
  description varchar(255)
);

-- Accept members
insert into musician (firstname, lastname, description) values ('Udo','Dirkschneider','Udo Dirkschneider (born April 6, 1952, Wuppertal, Germany) is a German heavy metal singer who is best known as the vocalist in German heavy metal band Accept and later U.D.O.');

-- Judas Priest members
insert into musician (firstname, lastname, description) values  ('Rob', 'Halford', 'There have been few vocalists in the history of heavy metal whose singing style has been as influential and instantly recognizable as Rob Halford.');
insert into musician (firstname, lastname, description) values ('Glenn', 'Tipton', 'Glenn Tipton is renowned as one-half of the legendary metal band Judas Priest''s groundbreaking twin-guitar attack.');

-- Iron Maiden members
insert into musician (firstname, lastname, description) values ('Bruce', 'Dickinson', 'Perhaps second only to Rob Halford, Iron Maiden''s Bruce Dickinson was the most acclaimed and instantly recognizable vocalist to emerge from the New Wave of British Heavy Metal movement of the early-''80s.');

select * from musician;

-- Band-Musician mapping table
create sequence band_member_id_seq;
create table band_member
(
  id int primary key not null default nextval('band_member_id_seq'),
  band_id int not null,
  musician_id int not null
);

insert into band_member (band_id, musician_id)
  values(
    (select band.id from band where band.name = 'Accept'),
    (select musician.id from musician where musician.firstname='Udo'));

insert into band_member (band_id, musician_id)
values(
  (select band.id from band where band.name = 'Judas Priest'),
  (select musician.id from musician where musician.firstname='Rob'));
insert into band_member (band_id, musician_id)
values(
  (select band.id from band where band.name = 'Judas Priest'),
  (select musician.id from musician where musician.firstname='Glenn'));


insert into band_member (band_id, musician_id)
values(
  (select band.id from band where band.name = 'Iron Maiden'),
  (select musician.id from musician where musician.firstname='Bruce'));

select * from band_member;

-- Instrument table --
create sequence instrument_id_seq;
create table instrument
(
  id int primary key not null default nextval('instrument_id_seq'),
  name varchar(50),
  description varchar(255)
);

-- Create View
create view band_view as (
  select band.id as band_id, band.name as band_name, musician.id as musician_id, musician.firstname, musician.lastname
  from band
    left outer join band_member
      on band.id = band_member.band_id
    left outer join musician
      on band_member.musician_id = musician.id
  order by band.name
);

select * from band_view;