FROM node:14.16.0
USER root

WORKDIR /frontend
COPY . /frontend

# Make variable API_URL to put uri into url
# uri 변수 형태로 받아서 url에 넣어 작동하도록 함
ARG API_URL
ENV REACT_APP_HOST_IP_ADDRESS $API_URL

RUN npm install
COPY . ./
