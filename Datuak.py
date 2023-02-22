import psycopg2

file = open("/home/uni/mezuak.txt",'r')
Lines = file.readlines()

try:
    connection = psycopg2.connect(user="postgres",password="mahi",host="192.168.65.95",port="5432",database="ev")
    cursor = connection.cursor()
    count = 0;
    for line in Lines:
        count += 1
        currentline = line.split(',')

        cursor.execute("select from langilea_langilea where erabiltzailea = '" +currentline[1]+ "'")
        erabiltzaileaExistitu = cursor.fetchone()
        if(erabiltzaileaExistitu == None):
            print("Erabiltzailea ez da existitzen")
        else:
            print("Erabiltzailea existitzen da")
        cursor.execute("select from partida_partida where id=" + currentline[0])
        repetido = cursor.fetchone()
        if(repetido != None or erabiltzaileaExistitu == None):
            print("ID errepikatuta edo erabiltzailea ez da existitzen")
        else:
            insertQuery = "insert into partida_partida(id,erabiltzailea_name,data,puntuazioa) values (%s,%s,%s,%s)"
            recordToInsert = (currentline[0],currentline[1],currentline[2],currentline[3])
            cursor.execute(insertQuery,recordToInsert)
            connection.commit()

        print(currentline[0],currentline[1],currentline[2],currentline[3])
    file.close()
except Exception as error:
    print(error)

