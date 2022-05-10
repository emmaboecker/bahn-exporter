# DB Exporter

This Project was designed to read data from [Marudor](https://github.com/marudor)'s [BahnhofsAbfahrten API](https://github.com/marudor/BahnhofsAbfahrten) every few minutes and write them into an InfluxDB Database.

## Setup

If you want to use this yourself here's a quick setup guide.

build the docker image and run it with a volume going to `/user/app/exporter.json`, this is your config file.

when you run it for the first time, the program will generate this basic config, or at least something similar:
```json
{
    "influx_address": "",
    "influx_token": "",
    "influx_org": "",
    "influx_bucket": "",
    "interval": 5,
    "targets": [
        {
            "name": "Frankfurt(Main)Hbf",
            "id": "8000105"
        }
    ]
}
```
Fill the values in the config files with the values of your choice. You can also add `base_api_url` if you dont wanna use [marudor.de](https://marudor.de/api) and `train_regex` if you don't want to use the default value of `ICE|RE|IC|IRE|RB|EC|ECE`.

If you don't know how to set up influx (and optionally grafana) you can go to [this](https://github.com/StckOverflw/apcsnmp#setup-idk-why-you-would-wanna-do-that-but-you-do-you) guide. You can pretty much use the same setup here. 

You can also change the value of `lookbehind` and `lookahead`

### Grafana Dashboard
I use this [this](https://gist.github.com/StckOverflw/97768261a2385ceb2204b73164000f76) configuration for my grafana dashboard
