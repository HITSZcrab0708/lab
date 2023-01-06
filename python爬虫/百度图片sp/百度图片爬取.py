#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time: 2021/9/2 3:30 下午
# @Project: 百度图片spider
# @Filename: 百度图片爬取.py
# @Author: macbookpro/Wang Entang
# @copyright版权所有©️尊重版权 抵制盗版

import re
import time

import requests
from urllib.parse import quote
import ssl
import os
ssl._create_default_https_context = ssl._create_unverified_context #跳过证书验证
baseurl="https://image.baidu.com/search/acjson?tn=resultjson_com&logid=10792998653006834451&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E9%A3%8E%E6%99%AF&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=&z=&ic=&hd=&latest=&copyright=&word="
keyword=input('请输入想搜索的图片：')
url=baseurl+quote(keyword)+"&s=&se=&tab=&width=&height=&face=&istype=&qc=&nc=&fr=&expermode=&nojc=&pn="#将搜索内容转化为URL编码的格式
print("正在生成链接：")
for i in range(0,10):
    print("--",end="")
    time.sleep(0.01)
print("\n")
print(url)
print("\n")

headers={
"Cookie": "BDqhfp=%E9%A3%8E%E6%99%AF%26%26NaN-1undefined%26%260%26%261; BDRCVFR[-pGxjrCMryR]=mk3SLVN4HKm; ab_sr=1.0.1_MTQ0MDNmNTE3MzJmNjhlOTEzZGFkMzliOWI1NWRjM2VmMmNjZWQyYmQxZmM5NTg3YzQ3MGE3OTAxNDZlNTNkOWUwZmFjZmI0MjJhMTBmZTk4N2RiMDQzNDcyYWNmMjlkZDEwOTkyYmJkY2ZiOTBmYmNkYjc4MDMyODQyYTU0OTkxZTRiOTRiYzQzMjgyMzc4YTVjZGY4ZDBmMzgxNmI1ZQ==; userFrom=www.baidu.com; BDRCVFR[dG2JNJb_ajR]=mk3SLVN4HKm; BDRCVFR[X_XKQks0S63]=mk3SLVN4HKm; cleanHistoryStatus=0; indexPageSugList=%5B%22%E9%A3%8E%E6%99%AF%22%2C%22%E8%A1%97%E6%8B%8D%22%5D; firstShowTip=1; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; H_PS_PSSID=34436_34497_31660_33848_34092_34107_26350_34419_34319; __yjs_duid=1_36193aafb9283a38099fe17df25cb2681630413482504; BAIDUID=B10FD97974D3D7E8E3F277880D8D9B24:FG=1; BIDUPSID=B10FD97974D3D7E88B85A865F8E11DEF; PSTM=1629788421",
"Accept-Language": "zh-cn",
"Host": "image.baidu.com",
"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Safari/605.1.15",
"Referer": "https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&word=%E9%A3%8E%E6%99%AF",
"Accept-Encoding": "gzip, deflate, br",
"Connection": "keep-alive",
"X-Requested-With": "XMLHttpRequest",
"Accept": "text/plain, */*; q=0.01"
}


html=""
pic_url = []
num=0
ran=int(input("请输入想爬取的页数:"))
while(ran<=0):
    print("输入有误，请重新输入")
    ran =input("请输入想爬取的页数:")
for i in range(0,ran):
    try:
        req = requests.get(url+str((i+1)*30), headers=headers)
        html=req.text
    except requests.ConnectionError:
        print('NONE')
    print("正在爬取：")
    print("\n")
    print(html)
    print("\n")

    pattern=re.compile('"thumbURL":"(.*?)"',re.S)   #将正则字符串编译成正则表达式对象
    pic_url1=re.findall(pattern,html)
    num+=len(pic_url1)
    pic_url.append(pic_url1)

print("共找到%d张图片"%(num))
print(pic_url)

print("正在下载：")
if not os.path.exists(keyword):
    os.mkdir(keyword)
i=1
for item in pic_url:
    for pic in item:
        try:
            response=requests.get(pic)
            if response.status_code == 200:
                file_path='{0}/{1}.{2}'.format(keyword,i,'jpg')
                if not os.path.exists(file_path):
                    with open(file_path,'wb') as f:
                        f.write(response.content)
                        print("下载完成第%d项"%(i))
            i+=1
        except requests.ConnectionError:
            print("FAIl TO SAVE IMAGE")

print("下载完成")




#/Users/macbookpro/Desktop/图片sp/百度图片爬取.py



