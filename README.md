```bash
docker cp build/libs/spark-demo.jar hadoop_hadoop_1:/soft/spark-2.4.0-bin-hadoop2.7/jars
```

```bash
bin/spark-submit \
  --class "ConfApp" \
  --master local[2] \
  /jars/spark-demo.jar
```
```
bin/spark-submit \
  --class workshop.wordcount.Product \
  --master local[2] \
  --packages com.typesafe:config:1.3.2 \
  /jars/data-engineering-workshop_2.11-0.1.jar
```

