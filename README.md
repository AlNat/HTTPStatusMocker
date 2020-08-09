# HTTPStatusMocker

![CI](https://github.com/AlNat/HTTPStatusMocker/workflows/CI/badge.svg)

A little Java-based application to mock any HTTP response status code.
Allow getting in response at any request wanted HTTP Status code.


### Test it

1. Get the latest docker image from [packages](https://github.com/AlNat/HTTPStatusMocker/packages)
    
    ```shell script
    docker login https://docker.pkg.github.com -u GITHUB_USERNAME -p TOKEN_WITH_READ_AND_WRITE_ACCESS
    docker pull docker.pkg.github.com/alnat/httpstatusmocker/httpstatusmocker:latest
    ```

1. Run application with Docker

    ```shell script
    docker run -d -p 3000:8080 docker.pkg.github.com/alnat/httpstatusmocker/httpstatusmocker
    ```

1. Make the request

    ```shell script
    curl --request GET -sL \
         --url 'http://localhost:3000\201?delay=1'
    ```
