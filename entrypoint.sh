#!/bin/sh

./sbin/start-master.sh
./sbin/start-slave.sh spark://$(hostname):7077

exec "$@"