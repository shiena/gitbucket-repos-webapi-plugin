import gitbucket.core.service.SystemSettingsService.SystemSettings
import gitbucket.core.util.Version
import gitbucket.repos.controller.RepositoriesController

class Plugin extends gitbucket.core.plugin.Plugin {
    override val pluginId: String = "repos-api"
    override val pluginName: String = "List Repositories API Plugin"
    override val description: String = "List Repositories API Plugin"
    override val versions: Seq[Version] = Seq(Version(1, 0))

    override val controllers = Seq(
        "/*" -> new RepositoriesController()
    )
}

