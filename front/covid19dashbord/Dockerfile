FROM node:12-alpine AS build
LABEL authors="adon1as"

WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx:alpine
COPY --from=build /usr/src/app/dist/covid19dashbord/ /usr/share/nginx/html
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
