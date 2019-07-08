# docker build -t "summer-routine" .

FROM alpine:3.10
LABEL maintainer="Konstantin Dobratulin <zsxoff@gmail.com>"
# ENTRYPOINT ["/bin/ksh"]

# update system
RUN apk update

# install some tools
RUN apk add openjdk8 openjdk8-jre gradle

# copy project
ADD . /pwd
WORKDIR /pwd

# add custom non-root user
RUN addgroup -S -g 1000 app
RUN adduser -D -S -G app -u 1000 johndoe
RUN chown -R johndoe:app ${PWD}
USER johndoe

# resolve dependencies
RUN gradle build --refresh-dependencies

# change entrypoint to Gradle
ENTRYPOINT ["/usr/bin/gradle"]