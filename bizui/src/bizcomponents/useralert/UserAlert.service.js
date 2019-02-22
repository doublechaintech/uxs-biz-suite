import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userAlertManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userAlertManager/loadUserAlert/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProfile = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userAlertManager/requestCandidateProfile/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfile = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}userAlertManager/transferToAnotherProfile/id/anotherProfileId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userAlertManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}userAlertManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const UserAlertService = { view,
  load,
  requestCandidateProfile,
  requestCandidatePlatform,
  transferToAnotherProfile,
  transferToAnotherPlatform }
export default UserAlertService

