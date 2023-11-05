#!/bin/bash

# Keystore dosyasının adını ve yolu
KEYSTORE_FILE="Kekik.keystore"

# Keystore anahtar adı
KEY_ALIAS="key0"

# Keystore şifresi
STORE_PASS="123456"
KEY_PASS="123456"

# Geçerlilik süresi (gün cinsinden)
Gecerlilik=10000

# Distinguished Name (DN) bilgileri
TamAd="keyiflerolsun"
Birim="Yazılım"
Organizasyon="KekikAkademi"
Bolge="Turkiye"
Eyalet="Istanbul"
Kod="TR"

# Keystore bilgilerini kullanarak keystore dosyasını oluştur
if keytool -genkeypair -v -keystore "$KEYSTORE_FILE" -keyalg RSA -keysize 2048 -validity "$Gecerlilik" -alias "$KEY_ALIAS" -keypass "$KEY_PASS" -storepass "$STORE_PASS" -dname "CN=$TamAd, OU=$Birim, O=$Organizasyon, L=$Bolge, ST=$Eyalet, C=$Kod"; then
  echo -e "\n\n[+] Keystore başarıyla oluşturuldu: $KEYSTORE_FILE\n\n"
else
  echo -e "\n\n[!] Keystore oluşturma başarısız: $KEYSTORE_FILE\n\n"
fi
