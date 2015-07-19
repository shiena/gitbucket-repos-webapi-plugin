# gitbucket-repos-webapi-plugin

This provides serveral Web API similar to GitHub API.

## List your repositories

`GET /api/v3/user/repos`

It look like https://developer.github.com/v3/repos/#list-your-repositories

## List user repositories

`GET /api/v3/users/:user/repos`

It look like https://developer.github.com/v3/repos/#list-user-repositories

# Installation

1. Hit `./sbt.sh package` in the root directory of this repository.
1. Copy `target/scala-2.11/gitbucket-repos-webapi-plugin_2.11-0.0.1.jar` into `GITBUCKET_HOME/plugins`.
1. Restart GitBucket.
