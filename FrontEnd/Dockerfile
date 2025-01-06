# Etapa 1: Usar imagem do Nginx para servir arquivos estáticos
FROM nginx:alpine

# Copiar os arquivos do frontend para o diretório onde o Nginx irá servir
COPY . /usr/share/nginx/html

# Expor a porta 80, que o Nginx usará para servir a aplicação
EXPOSE 80

# Nginx já é configurado para rodar automaticamente
CMD ["nginx", "-g", "daemon off;"]


#############################################

# Usar imagem do Nginx para servir arquivos estáticos
# FROM nginx:alpine

# # Instalar inotify-tools para monitorar mudanças de arquivos
# RUN apk add --no-cache inotify-tools

# # Copiar os arquivos do frontend para o diretório onde o Nginx irá servir
# COPY . /usr/share/nginx/html

# # Adicionar script para monitorar alterações e reiniciar o Nginx
# COPY ./scripts/restart-nginx.sh /usr/local/bin/restart-nginx.sh

# # Tornar o script executável
# RUN chmod +x /usr/local/bin/restart-nginx.sh

# # Expor a porta 80
# EXPOSE 80

# # Rodar o script para monitorar mudanças e reiniciar o Nginx
# CMD ["sh", "-c", "inotifywait -m -r -e modify,create,delete /usr/share/nginx/html && /usr/local/bin/restart-nginx.sh"]

