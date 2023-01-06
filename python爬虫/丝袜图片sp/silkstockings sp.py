#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time: 2021/9/7 2:56 下午
# @Project: 百度图片爬取.py
# @Filename: 丝袜爬取.py
# @Author: macbookpro

import requests
import re
import ssl
import os

ssl._create_default_https_context = ssl._create_unverified_context #跳过证书验证
baseurl="https://www.siwashi.com/"
print("请输入想爬取的类型：")
print("1.黑丝")
print("2.白丝")
print("3.肉丝")
print("4.其它")
choice=input()
if choice=="1":
    baseurl+="heisi/page/"
elif choice=="2":
    baseurl+="baisi/page/"
elif choice=="3":
    baseurl+="rosi/page/"
elif choice=="4":
    baseurl+="other/page/"
else :
    baseurl+="heisi/page"



headers={
"method": "GET",
"scheme": "https",
"authority": "www.siwashi.com",
"Accept": "*/*",
"Cookie": "Hm_lpvt_4c497184f82a9f0dcb9cf5d5a291ac13=1630997624; Hm_lvt_4c497184f82a9f0dcb9cf5d5a291ac13=1630997507,1630997600; _ga=GA1.2.37070832.1630997600; _gid=GA1.2.354020410.1630997600; PHPSESSID=900crc3bqmkqpqgoft25b6rk3u",
"Accept-Language": "zh-cn",
"Host": "www.siwashi.com",
"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Safari/605.1.15",
"Referer": "https://www.siwashi.com/heisi?cao_type=0",
"Accept-Encoding": "gzip, deflate, br",
"Connection": "keep-alive",
"X-Requested-With": "XMLHttpRequest"
}

pattern=re.compile('<img class="lazyload" data-src="(.*?)"',re.S)

while 1:
    a=input("爬取页数（一页10张）：")
    if a.isdigit():
        if int(a)>50:
            print("数字过大")
        else:
            break
    else:
        print("非法输入")


html=""
pic=[]

for i in range(0,int(a)):
    try:
        req=requests.get(baseurl+str(i+1)+"?cao_type=0",headers=headers)
        print(baseurl+str(i+1)+"?cao_type=0")
        html=req.text
    except requests.ConnectionError:
        print("ERROR")
    pic_url=re.findall(pattern,html)
    pic.append(pic_url)

print(pic)

name=input("请输入文件夹名称：")
if not os.path.exists(name):
    os.mkdir(name)
i=1


for pic1 in pic:
    for item in pic1:
        try:
            response=requests.get(item)
            file_path = '{0}/{1}.{2}'.format(name, i, 'jpg')
            if not os.path.exists(file_path):
                with open(file_path, 'wb') as f:
                    f.write(response.content)
                    print("下载第%d张"%(i))
            i+=1
        except requests.ConnectionError:
            print("FAIL")

print("DONE")


