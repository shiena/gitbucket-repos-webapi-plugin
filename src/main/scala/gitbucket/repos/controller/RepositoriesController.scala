package gitbucket.repos.controller

import gitbucket.core.api.{ApiRepository, ApiUser, JsonFormat}
import gitbucket.core.controller.ControllerBase
import gitbucket.core.service.{AccountService, RepositoryService}
import gitbucket.core.util.Implicits._

class RepositoriesController extends ControllerBase with AccountService with RepositoryService {
    /**
     * https://developer.github.com/v3/repos/#list-user-repositories
     */
    get("/api/v3/users/:userName/repos") {
      getAccountByUserName(params("userName")).map { account =>
        JsonFormat(
          getVisibleRepositories(
            context.loginAccount,
            context.baseUrl,
            Some(account.userName),
            withoutPhysicalInfo = true).map { repository =>
              ApiRepository(repository, ApiUser(getAccountByUserName(repository.owner).get))
          }
        )
      } getOrElse NotFound
    }
  
    /**
     * https://developer.github.com/v3/repos/#list-your-repositories
     */
    get("/api/v3/user/repos") {
      context.loginAccount.map { account =>
        JsonFormat(
          getUserRepositories(
            account.userName,
            context.baseUrl,
            withoutPhysicalInfo = true).map { repository =>
              ApiRepository(repository, ApiUser(getAccountByUserName(repository.owner).get))
          }
        )
      } getOrElse Unauthorized
    }

}

