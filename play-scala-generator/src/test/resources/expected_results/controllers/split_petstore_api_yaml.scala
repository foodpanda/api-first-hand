
import play.api.mvc.{Action,Controller}

import play.api.data.validation.Constraint

import play.api.inject.{ApplicationLifecycle,ConfigurationProvider}

import de.zalando.play.controllers._

import PlayBodyParsing._

import PlayValidations._

import scala.util._

import javax.inject._


/**
 * This controller is re-generated after each change in the specification.
 * Please only place your hand-written code between appropriate comments in the body of the controller.
 */

package split.petstore.api.yaml {
    // ----- Start of unmanaged code area for package SplitPetstoreApiYaml
    
    // ----- End of unmanaged code area for package SplitPetstoreApiYaml
    class SplitPetstoreApiYaml @Inject() (
        // ----- Start of unmanaged code area for injections SplitPetstoreApiYaml

        // ----- End of unmanaged code area for injections SplitPetstoreApiYaml
        lifecycle: ApplicationLifecycle,
        config: ConfigurationProvider
    ) extends SplitPetstoreApiYamlBase {
        // ----- Start of unmanaged code area for constructor SplitPetstoreApiYaml

        // ----- End of unmanaged code area for constructor SplitPetstoreApiYaml
        val findPetsByTags = findPetsByTagsAction { (tags: Option[ArrayWrapper[String]]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.findPetsByTags
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.findPetsByTags
        }
        val placeOrder = placeOrderAction { (body: Option[Order]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.placeOrder
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.placeOrder
        }
        val createUser = createUserAction { (body: Option[User]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.createUser
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.createUser
        }
        val createUsersWithListInput = createUsersWithListInputAction { (body: Option[Seq[User]]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.createUsersWithListInput
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.createUsersWithListInput
        }
        val getUserByName = getUserByNameAction { (username: String) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.getUserByName
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.getUserByName
        }
        val updateUser = updateUserAction { input: (String, Option[User]) =>
            val (username, body) = input
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.updateUser
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.updateUser
        }
        val deleteUser = deleteUserAction { (username: String) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.deleteUser
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.deleteUser
        }
        val updatePet = updatePetAction { (body: Option[Pet]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.updatePet
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.updatePet
        }
        val addPet = addPetAction { (body: Option[Pet]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.addPet
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.addPet
        }
        val createUsersWithArrayInput = createUsersWithArrayInputAction { (body: Option[Seq[User]]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.createUsersWithArrayInput
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.createUsersWithArrayInput
        }
        val getOrderById = getOrderByIdAction { (orderId: String) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.getOrderById
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.getOrderById
        }
        val deleteOrder = deleteOrderAction { (orderId: String) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.deleteOrder
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.deleteOrder
        }
        val logoutUser = logoutUserAction {  _ =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.logoutUser
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.logoutUser
        }
        val getPetById = getPetByIdAction { (petId: Long) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.getPetById
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.getPetById
        }
        val updatePetWithForm = updatePetWithFormAction { input: (String, String, String) =>
            val (petId, name, status) = input
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.updatePetWithForm
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.updatePetWithForm
        }
        val deletePet = deletePetAction { input: (String, Long) =>
            val (api_key, petId) = input
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.deletePet
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.deletePet
        }
        val findPetsByStatus = findPetsByStatusAction { (status: Option[ArrayWrapper[String]]) =>  
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.findPetsByStatus
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.findPetsByStatus
        }
        val loginUser = loginUserAction { input: (Option[String], Option[String]) =>
            val (username, password) = input
            // ----- Start of unmanaged code area for action  SplitPetstoreApiYaml.loginUser
            NotImplementedYet
            // ----- End of unmanaged code area for action  SplitPetstoreApiYaml.loginUser
        }
    
    }
}
